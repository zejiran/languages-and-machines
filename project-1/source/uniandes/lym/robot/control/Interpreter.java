package uniandes.lym.robot.control;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import uniandes.lym.robot.kernel.RobotWorld;
import uniandes.lym.robot.kernel.RobotWorldDec;




/**
 * Receives commands and relays them to the Robot. 
 */

public class Interpreter   {
	
	/**
	 * Robot's world
	 */
	private RobotWorldDec world;   
	
	
	
	/**
	 * Parser for a simple language 
	 */
	private Robot parser;

	/**
	 *  Builds a new Interprer 
	 */
	public Interpreter() {
		parser = new Robot(System.in);
	}

	/**
	 * Creates a parameterized interpreter with a robot world and the parser
	 * @param world, the robot world that will be used.
	 */
	public Interpreter(RobotWorld w) {
		world =  (RobotWorldDec) w;
		parser = new Robot(System.in);
		parser.setWorld(world);
	}
	
	


	
	/**
	 * sets a the world
	 * @param world 
	 */

	public void setWorld(RobotWorld m) 
	{
		world = (RobotWorldDec) m;
		parser.setWorld(world);
		
	}
	  
	
	
	
	/**
	 *  Processes a sequence of commands. A command is a letter  followed by a ";"
	 *  
	 *  
	 * @param input Contiene una cadena de texto enviada para ser interpretada
	 */
	
	/**
	 *  Inicia el procesamiento de �rdenes en formato texto
	 *  Recibe una cadena con  comandos, Le envia al parser esta  cadena para 
	 *  ser procesada. Inicia el timer para que se procese una cadena una a una
	 * @param input Contiene una cadena de texto enviada para ser interpretada
	 */
	public String process(String input) {   
		//Manda la cadena como stream al parser que procesa
		parser.ReInit(new java.io.StringReader(input));
		StringBuffer salida=new StringBuffer("Sistema: \n-->");	

		// mundo.resetStacks();
		try {                  		
			while (parser.command(salida)){
				//mundo.resetStacks();	
				salida.append(" \n--> ");
			}
		}  catch(ParseException pex) {		
			//System.out.println(mundo.getValueStack());
			salida.append("Error de sintaxis:"+pex.getMessage()+" \n--> ");
			//mundo.cleanTemp();
		} catch (Error err) {
			//		 System.out.println("stack: "+mundo.getValueStack());
			salida.append("Error "+err.getMessage()+" \n--> ");
			//	 mundo.cleanTemp();
		} catch (Exception error) {
			// System.out.println(mundo.getValueStack());
			salida.append("Error de ejecuci�n"+error.getStackTrace()+" \n--> ");
			//mundo.cleanTemp();
		}
		return salida+" End Input \n";
	}


	
}
	    