package uniandes.lym.robot.view;

  
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import uniandes.lym.robot.kernel.*;

/**
 * A  board provides the visualization of the robot's world
 * Implements  java.beans.PropertyChangeListener to be able to update  the board's view
 * @see kernel.RobotWorld
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements PropertyChangeListener {
	/**
	 *  robot world that is being visualized by this component
	 */
	private RobotWorld world; 
	
	/**
	 * Visual component for the Robot World
	 */
	private JLabel[][] tabla;
	
	/**
	 * Boar size
	 */
	private Dimension size;
	
		 
	/**
	 * Creates the visualization object for viewing the corresponding RobotWorld
 	 * @param robotWorld
	 */
	public Board(RobotWorld world) {
		this.world = world;
		this.tabla = new JLabel[world.getN()+1][world.getN()+1];
		//size
		int tam = 40*(world.getN()+1);
		this.size = new Dimension(tam,tam);
		this.setSize(this.size);
		this.world.addObserver(this);
		this.setLayout(new GridLayout(world.getN()+1,world.getN()+1,0,0));
		Images.inicializar(this);
		redrawWorld();
	}
	
	/**
	 * This method is invoked when there have been updates to the model. The view must be updated accordingly
	 * @param evt receives   Change object that indicates what cells must be repainted.
	 * @see kernel.Change
	 */ 
	@Override
	 public void propertyChange(PropertyChangeEvent evt) {
	  	Object arg = evt.getNewValue() ;
		 if (arg instanceof Change ){
		 final Change c = (Change)arg;
		 final Point init = c.getStart();
         final Point end = c.getEnd(); 
        
         if ((int)init.getX() > world.getN() ||(int)init.getY() >world.getN() || (int)end.getX() > world.getN() ||(int)end.getY()> world.getN())
		 	redrawWorld();
		 else {
		 	draw(init);
		 	draw(end);
		 }
		}
		else if (arg instanceof Integer) {
			Integer val =  (Integer) arg;
			reset(val.intValue());
			Console.relaunch(val);
		}
    }
	
	 /**
	  * Draws the cell at the given position.
	  * If  it is row zero it displays the column number
	  * If it is column zero it displays the row number
	  * If there are chips or balloons it draws a balloon.
	  * If the  robot is located there, it paints the robot.
	  * @param p : the location to be drawn
	  */
	  public void draw(Point p) {
		 int x = (int)p.getX();
		 int y = (int)p.getY();
		 boolean tieneGlobo = false;
		 String balloons="no balloons"; // tool tip for the cell
		
	 String  id;
				 
		if ((x==0) || (y==0)) {
			 if ((x==0) && (y==0)) 
				 //Top left corner must be empty
				 id = "";
			  else if (x==0)
				 //first row, draw numbers
				 id = String.valueOf(y);
			  else  
				 //first column draw numbers
				 id = String.valueOf(x);
			  if(this.tabla[x][y]==null) 
				 //first draw
				 this.tabla[x][y]= new JLabel(id);
			  else 
				 //subsequent draws
				 this.tabla[x][y].setText(id);
		} else {
			 int numGlobos = this.world.countBalloons(p);
			 if(numGlobos>0) {
			 	tieneGlobo = true;
			 	balloons =  String.valueOf(numGlobos) + " balloons";
			 }
			 int facing1 = 0;
			 if(p.equals(this.world.getPosition())) {
				 balloons = balloons + ". "+ "has "+ this.world.getMyBalloons()+ " balloons and "+ this.world.getMyChips()+ " chipss." ;
				if(this.world.getFacing() == RobotWorld.NORTH){
					facing1 = 4;
				}else if(this.world.getFacing() == RobotWorld.SOUTH){
					facing1 = 12;
				}else if(this.world.getFacing() == RobotWorld.EAST){
					facing1 = 8;
				}else{
					facing1 =16;
				}
			 }
			 // Get tile image
			 Icon o;
			 if(this.world.isBlocked(p)) 
				 o  = Images.get(20);
			 else 
				 o  = Images.get(((this.world.chipExists(p))?1:0) + ((tieneGlobo)?2:0) + facing1);
			 if(this.tabla[x][y]==null) {
			 	 this.tabla[x][y]= new JLabel(o);
			 } else {
				 this.tabla[x][y].setIcon(o);
			 }
			 this.tabla[x][y].setToolTipText(balloons);
		}
	 }
	  
	 /**
	  * Draws the board for the first time
	  */
	 private void redrawWorld() {
		for(int b=0; b<=this.world.getN(); b++) {
			for(int a=0; a<=this.world.getN(); a++) {
				this.draw(new Point(a,b));
				this.add(this.tabla[a][b]);
			}
		}
	 }
	 
	 /**
	  * Returns the min size of the board 
	  */
	 public Dimension getMinimumSize() {
		 return this.size;
	 }
	 
	 /**
	  * Returns the board size
	  */
	 public Dimension getSize() {
		return this.size;
	 }
	 
	 /**
	  * Returns the world
	  */
	 public RobotWorld getWorld() {
		 return this.world;
	 }

	 //public void reset(int dim, Point nuevaPos, int nuevosGlobos, int nuevasFichas, boolean limpiar) 
	 public void reset(int dim) {
		 this.tabla = new JLabel[dim+1][dim+1];
		 int tam = 40*(world.getN()+1);
		 this.size = new Dimension(tam,tam);
		 this.removeAll();
		 this.setSize(this.size);

		 this.setLayout(new GridLayout(world.getN()+1,world.getN()+1,0,0));
		 redrawWorld();
	 }
}
