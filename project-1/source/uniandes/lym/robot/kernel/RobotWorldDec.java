package uniandes.lym.robot.kernel;

import java.awt.Point;

/**
* Decorates world with more complex instructions
*  Adds error management. 
*  Adds a function that allows negative arguments horizontally or vertically.
*/
public class RobotWorldDec extends RobotWorld {
   
	public RobotWorldDec (int tam, Point p, int initGlobos, int initFichas){ 	
	 	super(tam,p, initGlobos, initFichas);	
	}

	/**
	 * @return spaces available to put chips.
	 */	
	public int freeSpacesForChips(){
		Point myPos = getPosition();
		int n = getObstacle();
		int i;
	       
		for(i=myPos.y; i <= n  && !chipExists(new Point(myPos.x,i)); i++);
		return i-myPos.y;
	}

	/**   
	 * @return number of chips on or above the current position. 
	 */
	public int chipsToPick(){
		Point myPos=getPosition();
		int i;
	      
		for(i=myPos.y; i > 0 && chipExists(new Point(myPos.x,i)); i--){}
		return myPos.y-i;
	}

	/**
	* Used to move the robot horizontally on the board
	* @param  steps to move (if steps > 0 it moves to the right; if steps < 0 it moves to the left. 
	* @throws  Error if the robot ends up outside the board
	*/
	public void moveHorizontally(int steps) throws Error {
		Point p =getPosition();
		int tam = getN();
		int newX;
		
		newX = p.x+steps;
		
		if (newX > tam) 
			throw new Error("Fell off  the right");
    	else if (newX < 1) 
			throw new Error("Fell off the left");
		else { 
			if (steps >= 0)  {
				for (int i=0; i<steps; i++)	
            		right();        
    		} else {
				for (int i=0; i>steps; i--) 
            		left();
     		}
		}
	}

	/**
	* Used to move the robot vertically on the board
	* @param  steps to move (if steps > 0 it moves down; if steps < 0 it moves up. 
	* @throws  Error if the robot ends up outside the board
	*/
	public void moveVertically(int steps) throws Error {
		Point p =getPosition();
		int tam = getN();
		int newY,i;
		
		newY = p.y+steps;
		int dir = 5;
		if(p.y - newY > 0)
			dir = NORTH;
		else
			dir = SOUTH;
		if (newY > tam)
			throw new Error("Fell off  the bottom");
		else if (newY < 1)
			throw new Error("Fell off the top");
		else if(blockedInRange(p.x, p.y, newY, dir))
			throw new Error("There is an obstacle in the path");
		else { 
			if (steps >= 0)  {
				for (i=0;i<steps;i++)	
					down();        
			} else {
				for (i=0;i>steps;i--) 
					up();
			}
		}
	}	
	
	/**
	* Pick up chips
	* @param f chips to pick up
	* @throws Error if there are less than f chips. 
	*/
	public void pickChips(int f) throws Error {
		if (f < 0)
			throw new Error ("Number of chips should be positive");
		else if (f>chipsToPick())
			throw new Error ("There are not enough chips");	
		else {
			for (int i=0; i<f; i++) {
				pickupChip();
			}	
		}
	}		
	
	/**
	* Method used for putting chips
	* @param f number of chips to put
	* @throws Error if:  f is  negative,  there is not enough room for the chips or if the robot does not have enough chips 
	*/
	public void putChips(int f) throws Error {
		if (f < 0)
			throw new Error ("Number of chips should be positive");
		else if (f>freeSpacesForChips())
			throw new Error ("Chips do not fit");	
		else if (getMyChips()< f) 
			throw new Error("Robot does not have enough chips");
		else {
			for (int i=0; i<f; i++) {
				putChip();
			}
		}
	}
	
	/**
	* Method used for grabbing balloons that are on the same position as the robot.
	* @param g Number of balloons to grab
	* @throws Error if g is negative or if there are not enough balloons
	*/
	public void grabBalloons(int g) throws Error {
		if (g < 0)
			throw new Error("Number of balloons should be positive");
		else if(countBalloons(getPosition()) < g) {
			throw new Error("There are less than "+g+" balloons!");
		}	
		for (int i=0; i<g; i++) {
			pickupBalloon();
		}
	}		
	
	/**
	* Method used for popping balloons that are on the same position as the robot.
	* @param g Number of balloons to grab
	* @throws Error if g is negative or if there are not enough balloons
	*/
	public void popBalloons(int g) throws Error {
		if (g < 0)
			throw new Error("Number of balloons should be positive");
		else if(countBalloons(getPosition()) < g) {
			throw new Error("There are less than "+g+" balloons!");
		}	
		for (int i=0; i<g; i++) {
			popBalloon();
		}
	}	
	
	/**
	* put balloons
	* @param g Number of balloons to put
	* @throws Error if there are not enough balloons 
	*/
	public void putBalloons(int g) throws Error {
		if (g < 0)
			throw new Error("Number of balloons should be positive");
		else if (getMyBalloons()< g)
			throw new Error("Robot has less than "+g+" balloons!");
		else
			for (int i=0; i<g; i++) {
				putBalloon();
			}
	}
	
	/*New instructions*/
	/**
	 * Used to move the robot forward
	 * @param steps number of steps to move in the direction it is facing.
	 * @throws  Error if the robot ends up outside the board
	*/	
	public void moveForward(int pasos) throws Error {
		int orient = getFacing();
		if(orient == NORTH)
			moveVertically(-pasos);
		else if(orient == SOUTH) 
			moveVertically(pasos);
		else if(orient == EAST)
			moveHorizontally(pasos);
		else
			moveHorizontally(-pasos);
	}
}  


