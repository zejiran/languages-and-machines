package uniandes.lym.robot.kernel;


import java.awt.Point;
import java.util.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Robot World is an square board with a robot that moves from cell to cell 
 * There are chips. There can only be one chip per cell. The robot starts with some chips and some .
 * The Robot can put and pickUp chips and . When the robot places a chip, it falls
 * bottom row, or to the row above the last placed chip. 
 *  float and there can be more than one balloon in a cell.
 * This class does not  implement visualization.
 * <b>Note :</b>Invalid operations cause unexpected behavior, no exceptions are raised.
 * This class communicates  with the interface using PropertyChangeSupport.
 *  This class used to extend Observable 
 */
public class RobotWorld {
	PropertyChangeSupport pcs = new  PropertyChangeSupport(this);
	
	public void addObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("theProperty", l);
	}
	
	
	/** 
	 * 	Constants to model the direction that the robot is facing
	 */
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	
	/**
	 * The dimension of the board. Being a square, only one value suffices.
	*/
	private int n;
	
	/**  Cell where the robot is located */
	private Point position;
	
	/**
	 * Set of positions that contain chips
	 */
	private HashSet <Point> chips;
	
	/**
	 * Set of positions in which there is an obstacle in the board
	 * Nor the robot, chips, or  can go on blocked cells 
	*/
	private HashSet <Point> blocked;
	
	/**  Number of  held by the Robot*/
	private int ballons;
	
	/** Number of Chips held by the Robot*/
	private int myChips;
	
	
	/**   Last change performed on the world */
	private Change change;
	
	/**  int table used to store the number of  in each cell */
	private int balloons[][];
	
	/**  Orientation that the robot is facing */
	private int facing;
	
	/**
	 * RobotWorld constructor
	 * @param dim  World dimension
	 * @param pos Robot's Initial position
	 * @param initB initial number of 
	 * @param initC initial number of chips
	 */
	public RobotWorld(int dim, Point pos, int initB, int initC) {
		this.n = dim;
		this.position = pos;
		this.myChips = initC;
		this.ballons = initB;
		
		// Initially there are no chips nor  
		this.chips = new HashSet <Point>();
		this.balloons = new int[dim][dim];

		// No change
		this.change = new Change();
		
		//Initially facing north
		this.facing = NORTH;
		this.blockTiles();
	}

	
	/** 
	 * Default constructor:  size 8, at position (1,1) with 630  and 64 chips 
	 */
	public RobotWorld(){
		this(8,new Point(1,1),640,64);
	}	

	/**
	 * Start the board with some randomly allocated blcoked tiles 
	 */
	private void blockTiles() {
		int  numTiles = 5;  
		this.blocked = new HashSet <Point>();
		for(int i=0; i<numTiles; i++) {
			Random r = new Random();
			blocked.add(new Point(r.nextInt(this.n - 2) + 2, r.nextInt(this.n - 2) + 2));
		}
	}
	
	/**
	 * Reinitializes world attributes
	 * @param pos Robot's  position
	 * @param newB new number of 
	 * @param newC new number of chips
	 * @param clean:  if false then then the current  and chips are left on the board
	 *                 if true the cells are left without chips and without .
	 */
	public void restart(Point pos, int newB, int newC, boolean clean) {
		position = pos;
		ballons = newB;
		myChips = newC;
		if (clean) {
			for(int i=0; i<n; i++) {
				for (int j=0; j<n; j++)
					balloons[i][j]=0;
			}
			chips.clear();			
		}

		change.setEnd(new Point(n+1,n+1));
		change.setStart(new Point(n+1,n+1));
		pcs.firePropertyChange("theProperty", n, change);
	}
	
	/**
	 * Move the robot left
	 * If the robot is at the far left, the behavior is not defined
	 */
	public void left() {
		this.change.setStart(new Point(this.position));
		this.position.translate(-1,0);
		buscarErrores();
		inform();
	}

	/**
	 * Move the robot right
	 * If the robot is at the far left, the behavior is not defined
	 */
	public void right() {
		this.change.setStart(new Point(this.position));
		this.position.translate(1,0);
		buscarErrores();
		inform();
	}
	
	/**
	 * Move the robot up
	 * If the robot is at the far left, the behavior is not defined
	 */
	public void up() {
		this.change.setStart(new Point(this.position));
		this.position.translate(0,-1);
		buscarErrores();
		inform();
	}
	/**
	 * Move the robot down
	 * If the robot is at the far left, the behavior is not defined
	 */
	public void down() {
		this.change.setStart(new Point(this.position));
		this.position.translate(0,1);
		buscarErrores();
		inform();
	}
	
	/**
	 *  Puts a balloon in its current position, incrementing the number of  in that position.
	 *  If the robot has no , the behavior is nor defined
	 */
	public void putBalloon() {
		int x = (int)this.position.getX();
		int y = (int)this.position.getY();	
		this.balloons[x-1][y-1]++;
		this.ballons--;
		buscarErrores();
		inform();
	}

	/**
	 * Picks a balloon from its position
	 * If there are no balloons, the behavior is not defined.
	 */
	public void pickupBalloon() {
		int x = (int)this.position.getX();
		int y = (int)this.position.getY();	
		this.balloons[x-1][y-1]--;
		this.ballons++;
		buscarErrores();
		inform();
	}
	
	
	/**
	 * Pops a balloon from the robot's position
	 * If there are no balloons, the behavior is not defined.
	 */
	public void popBalloon() {
		int x = (int)this.position.getX();
		int y = (int)this.position.getY();	
		this.balloons[x-1][y-1]--;
		buscarErrores();
		inform();
	}
	
	/**
	 * Puts a chip in the current position. If there is a chip in that positions already, the behavior is undefined
	 * Chips don't float so you need to check what is happening in the positions underneath the current position
	 */
	public void putChip() {
		//De acuerdo al API de java.util.HashSet la funcion add devuelve un valor de verdad
		//que es cierto si se esta incertando por primera vez, falso en caso contrario
		//Si no se esta insertando por primera vez eso indica que ya habia ficha en la position en la que 
		int y = (int)this.position.getY();
		int b;
		boolean yaPuesta=false;
		Point p= new Point(this.position);
		for(b=getObstacle(); b>=y; b--) {
			p.setLocation(p.getX(),b);
			if(!this.chipExists(p)) {//No chip, it can be placed
				yaPuesta=true;	
				this.change.setStart(new Point(p));				
				this.chips.add(p);
				inform();
				break;
			}
		}
		if(!yaPuesta) {
			this.position = new Point(1,1);
			comportamientoDeError("Can't put chip");
			inform();
		} else {
		  myChips--;
		  inform();	
		}
	}
	
	/**
	 * Attempts to pickup a chip.
	 * If there is a chip, then the robot keeps it and all chips above it fall one position
	 * If there is no chip, the behavior is undefined.
	 */
	public void pickupChip() {
		int y = (int)this.position.getY();
		int x = (int)this.position.getX();
		int b;
		Point old, next;
		old = 	new Point(this.position);
		next = new Point(this.position);
			
		if(!this.chipExists(this.position)) {
			comportamientoDeError("No chip to put");
			inform();
		} else { //Check: 1. THere is a chip 2. No chips
	    myChips++;

		  if (y != 0) {
			  next.setLocation(next.getX(),y-1);
			if (!this.chipExists(next)){
			
				this.change.setStart(this.position);
				this.chips.remove(this.position);
				inform();
			} else {
              if (y-2 < 0) {
            	  old.setLocation(next.getX(),next.getY());
			  } else {                    
				for(b=y-2;b >= 0 && this.chipExists(next);b--){
					old.setLocation(next.getX(),next.getY());
					next.setLocation(next.getX(),b);
			   	}
              }
			  this.change.setStart(old);
			  this.chips.remove(old);
			  inform();
              this.position.setLocation(x,y);  
			  inform();
			}		
		  } else {
			this.change.setStart(this.position);
			this.chips.remove(this.position);
			inform();
			}
		}
	}
	
	/**
	 * Used to determine if there was an error:
	 *  Robot's position outside the board
	 *  Robot with a negative number of chips or 
	 *  Positions with a negative number of 
	 *  Errors due to placing chips are taken care of it the nethod putChips
	 *  If there is an error, errorBehavior is invoked 
	 */	
	private void buscarErrores() {
		int x,y;
		x = (int)this.position.getX();
		y = (int)this.position.getY();		
		if(x < 1 || x > this.n) 
				comportamientoDeError("Illegal column: "+ x);
		else if ( y<1 || y>this.n )  
				comportamientoDeError("Illegal row: "+ y);
		else if (this.myChips < 0) 
			comportamientoDeError("Not enough chips o put:" + (-this.myChips));
		else if ( this.ballons < 0 ) 
			comportamientoDeError("Not enough  to put:" + (-this.ballons));
		else if (this.balloons[x-1][y-1]< 0)
			comportamientoDeError("Not enough  to pick" + (-this.ballons));
	}

	/**
	* Error Behavior: world without chips, 
	*/
	private void comportamientoDeError(String message) throws Error  {
		this.position = new Point(1,1);			
		this.myChips = 0;
		this.ballons = 0;
		
		change.setEnd(new Point(n+1,n+1));
		change.setStart(new Point(0,0));
		
		pcs.firePropertyChange("theProperty", n, change);
		throw new Error(message);
	}

	/**
	 * Notifies observers about the object's change 
	 * @see java.util.Observer
	 */
	protected void inform() {
		this.change.setEnd(this.position);
		pcs.firePropertyChange("theProperty", n, change);
	}
		
	/**
	 * @return robot's current position
	 */
	public Point getPosition() {
		return this.position;
	}
	/**
	 * @return board size
	 */
	public int getN() {
		return this.n;
	}
	
	/**
	 * Returns the position of the first blocked cell down the current position of the robot
	 * @return int
	 */
	public int getObstacle() {
		for(int i=position.y; i<=this.n; i++) {
			if(isBlocked(new Point(position.x, i)))
				return i-1;
		}
		return this.n;
	}
	
	/**
	* @return number of  held by the robot
    */
	public int getMyBalloons() {
		return this.ballons;
	}
	/**
	* @return number of chips held by the robot
    */
	public int getMyChips() {
			return this.myChips;
	}

	/**
	 * @return true if there is a chip in cell p; false otherwise 
	 * */
	public boolean chipExists(Point p) {
		return this.chips.contains(p);
	}
	/**
	 * @return true if there is a chip in the robot's current position; false otherwise 
	 * 
	 * */
	public boolean chipExists() {
		return this.chips.contains(this.position);
	}
	
	public boolean blockedInRange(int posX, int posY, int newPos, int dir) {
		boolean checkBlocked = false;
		if(dir==NORTH) {
			for(int i=posY; i >= newPos && !checkBlocked; i--) {
				checkBlocked = isBlocked(new Point(posX, i));
			}
		} else if(dir==SOUTH) {
			for(int i=posY; i <= newPos && !checkBlocked; i++) {
				checkBlocked = isBlocked(new Point(posX, i));
			}
		}else if(dir==EAST) {
			for(int i=posX; i <= newPos && !checkBlocked; i++) {
				checkBlocked = isBlocked(new Point(i, posY));
			}
		} else if(dir==WEST) {
			for(int i=posX; i >= newPos && !checkBlocked; i--) {
				checkBlocked = isBlocked(new Point(i, posY));
			}
		}
		return checkBlocked;
	}
	
	/**
	 * Returns whether the given point is blocked
	 * @param p Point on the board 
	 * @return true if the point is blocked
	 */
	public boolean isBlocked(Point p) {
		return this.blocked.contains(p);
	}
	
	/**
	 * Returns the numbers of balloons in a given point
	 * @param p is the given point. If p is not within the board a NullPointerException is thrown.
	 * @return balloons[p]
	 */
	public int countBalloons(Point p) {
		return this.balloons[p.x-1][p.y-1];
	}
	
	/**
	 * Returns the number of balloons in the current position
	 * @return ballons.count
	 */
	public int countBalloons() {
		return this.balloons[(this.position).x-1][(this.position).y-1];
	}
	
	/**
	 * @return true if there are balloons in the current position
	 */
	public boolean containsBallons() {
		if ( this.balloons[(this.position).x-1][(this.position).y-1] > 0 )
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return true if it is in the first row
	 */
	public boolean isUp() {
		return this.position.y==1;
	}
	
	/**
	 * @return true if it is in the last row
	 */
	public boolean isDown() {
		return this.position.y==this.n;
	}
	
	/**
	 * @return true if it is in the first column
	 */
	public boolean isLeft() {
		return this.position.x==1;
	}
	
	/**
	 * @return true if it is in the last column
	 */
	public boolean isRight() {
		return this.position.x==this.n;
	}


	/**
	 * Reinitializes world attributes
	 * @paeam din  new size
	 * @param pos Robot's  position
	 * @param newB new number of 
	 * @param newC new number of chips
	 * @param clean:  if false then then the current  and chips are left on the board
	 *                 if true the cells are left without chips and without .
	 */
	
	public void restart(int dim, Point pos, int newB, int newC, boolean clean) {
		int tempballoons[][] = new int[dim][dim];
		int  minDim = (n<dim)?n: dim; 
		Point tempchips[] = (Point [])chips.toArray();
		
		n = dim;
		position = pos;
		ballons = newB;
		myChips = newC;
		
		
		if (clean) {
			chips.clear();		
			balloons = tempballoons;
		}
		else {	
			for(int i=0; i<minDim; i++) 
				for (int j=0; j<minDim; j++)
					tempballoons[i][j]=balloons[i][j];
			balloons = tempballoons;			
			if (dim < n) {		
				for (int i=0; i < tempchips.length; i++) {
					Point pf1 = tempchips[i];
					if (pf1.x > dim || pf1.y > dim) 
						chips.remove(pf1);
				}
			}
		}
		
		// there is no change
		this.change = new Change();
		change.setEnd(new Point(n+1,n+1));
		change.setStart(new Point(n+1,n+1));
		pcs.firePropertyChange("theProperty", n, change);
}

	
	
	/** 
	 * Modifies the wolrd's size without changing anything else. the 
	 * size is decreased and the robots ends up outside the new dimensions, it is placed at the end of the world
	 * @param dim new size
	 */
	public void restart(int dim) {
		int tempballoons[][] = new int[dim][dim];
		int  minDim = Math.min(dim,n); 
		Point tempchips[] = (Point [])chips.toArray();
				
		position.x = Math.min(dim,position.x);
		position.y =  Math.min(dim,position.y);
				
		for(int i=0; i<minDim; i++) 
			for (int j=0; j<minDim; j++) 
				tempballoons[i][j]=balloons[i][j];
		
		if (dim < n) {		
			for (int i=0; i < tempchips.length; i++) {
				Point pf1 = tempchips[i];
				if (pf1.x > dim || pf1.y > dim) 
					chips.remove(pf1);
			}
		}
		
		balloons = tempballoons;			
		n = dim;
		
		this.change = new Change();
		change.setEnd(new Point(n+1,n+1));
		pcs.firePropertyChange("theProperty", n, change);
	}	
	
	/**
	 * verifies whether or not  robot is facing north
	 * @return true if robot is facing north; false otherwise
	 */
	public boolean facingNorth() {
		return this.facing==NORTH;
	}
	
	/**
	 * verifies whether or not  robot is facing south
	 * @return true if robot is facing south; false otherwise
	 */
	public boolean facingSouth() {
		return this.facing==SOUTH;
	}
	
	/**
	 * verifies whether or not  robot is facing east
	 * @return true if robot is facing east; false otherwise
	 */
	public boolean facingEast() {
		return this.facing==EAST;
	}
	/**
	 * verifies whether or not  robot is facing west
	 * @return true if robot is facing west; false otherwise
	 */
	public boolean facingWest() {
		return this.facing==WEST;
	}
	
	/**
	 * 
	 * @return The robot's orientation SOUTH, EAST OR WEST).
	 */
	public int getFacing(){
		return this.facing;
	}
	
	/**
	 * Turns the robot 90 degrees to the right. 
	 */
	public void turnRight(){
		if(this.facing == NORTH)
			this.facing = EAST;
		else if(this.facing == SOUTH)
			this.facing = WEST;
		else if(this.facing == EAST)
			this.facing = SOUTH;
		else 
			this.facing = NORTH;
		inform();
	}
}
