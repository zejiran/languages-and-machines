
package uniandes.lym.robot.kernel;
import java.awt.Point;
/**
 * Change: Specifies a modification by specifying start and end points.
 **/
public class Change
{
	/**   Initial point*/
	private Point start;
	
	/*  End pint */
	private Point end;
	
	/** Crates a new change with start and end = (0,0) */
	
	public Change() {
		this.start = new Point(0,0);
		this.end = new Point(0,0);
	}
	
	/** Returns  the initial point */
	
	public Point getStart() {
		return this.start;
	}
	
	/** Returns  the fina point */

	public Point getEnd() {
		return this.end;
	}
	/** Sets the initial point
	 * @param start the new initial point
	 */

	public void setStart(Point start) {
		this.start = start;
	}

	/** Sets the end point 
	 * @param end the new end point
	 */
	public void setEnd(Point end) {
		this.end = end;
	}
}
