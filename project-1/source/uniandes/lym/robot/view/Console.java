package uniandes.lym.robot.view;

 
import java.lang.reflect.InvocationTargetException;




import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import uniandes.lym.robot.control.*;
import uniandes.lym.robot.kernel.*;

/**
 * Manages the application's command console with:
 *   TextArea: History of commands sent and app's reponses 
 *   Button  to send   
 *   Button to quit
 * 
 * GUI of the interpreterr
 * Closely inspired on: TextDemo.java, from the Java tutorial:
 * <a href='http://java.sun.com/docs/books/tutorial/uiswing/components/textfield.html'>java.sun.com</a>
 * @see interpreterr.interpreter
 * @author  1. Juan Pablo Morales
 *          S. Takahashi
 *          Leandro Franco. Adds  command possibility of navigating command history 
 * */
@SuppressWarnings("serial")
public class Console extends JPanel  { 
	//The Vector of commands for the historial
  	static Vector <String> commands = new Vector<String> ();

  	//The number of commands
  	static int contCom = 0;	
	
	/**
	 * El interpreter al que esta console da ordenes
	 */
	static private Interpreter interpreter = new Interpreter();
	
	/**
	 * El area de texto que se usa para los mensajes del system
	 */
	static private JTextArea system =  new JTextArea(10,30);
 
	
	
	/**
	 * El campo de texto en el que el usuario puede escribir mensajes para que
	 * la console los interpreter
	 */
	static private JTextArea orden = new JTextArea(10,30);
	
	/**
	* Boton para enviar texto al interpreter
	*/
	static private JButton enviar = new JButton("RUN");
	
	/**
	* Boton para Salir
	*/
	static private JButton salir = new JButton("EXIT");

	/** 
	* ScrollPanes para que  el log y la entrada se pueda mostrar con ScrollBars
	*/ 
           
	static private JScrollPane scrollPanesystem = new JScrollPane(system);
	static private JScrollPane scrollPaneOrden = new JScrollPane(orden);

	/**
	 * Runnable class para controlar el flujo de ejecuci�n al escribir en la
	 * ventana del system
	 */
	
	final OutputPrinter escribirEnsystem = new OutputPrinter();
	
	
	//static  CodeViewPanel      codeView     = new CodeViewPanel();  
//	static  ValueStackPanel stackView = new ValueStackPanel();  
	
	//static private JScrollPane scrollCodeView = new JScrollPane(codeView);	
	//static private JScrollPane scrollStackView = new JScrollPane(stackView);
	
	//static private RunningMacroPanel debugPanel = new RunningMacroPanel(scrollStackView);
	static private Board board;
	static private Console console;
	static private JFrame frame;
	/**
	 * Crea una nueva console que se encarga de dar ordenes a un determinado
	 * mundo a traves de un interpreter
	 * @param mundo El mundo al que esta console manejara
	 */
	
	public Console(RobotWorld mundo) {
		
		
		interpreter.setWorld(mundo);

		
	    orden.addKeyListener(new KeyAdapter(this));
		addActions();
		
		//El log no se debe poder modificar
		system.setEditable(false);
		
		
		/*
		 * El GridBagLayout es otra forma de poner los componentes, mucho mas
		 * flexible, que permite decidir como son las posiciones, dimensiones y
		 * comportamientos de los objetos unos con otros
		 */

		
		GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints c = new GridBagConstraints();
		
        //Hace que el componente ocupe todo lo ancho
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
		gridBag.setConstraints(scrollPanesystem,c);
        c.weightx =1.0;
        c.weighty = 1.0;
        add(scrollPanesystem);
        c.fill = GridBagConstraints.HORIZONTAL;
        gridBag.setConstraints(scrollPaneOrden,c);
        add(scrollPaneOrden);
        add(enviar);
     	add(salir);
     	
     	
   }
	
public static void relaunch(int dim){
		
		//board.reset(dim);
		frame.pack();
		
	    //Center the window
		Dimension frameSize = frame.getSize();
		frame.setResizable(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	
 }	 
	
	/**
	 * Ejecuta sincr�nicamente la orden de escrbir en TextArea system
	 * @param msg
	 */
	
	private void printOutput(String msg) {
	
		escribirEnsystem.setMessage(msg);
		try {
			SwingUtilities.invokeAndWait(escribirEnsystem);
		} catch (InterruptedException e) {
					e.printStackTrace();
		} catch (InvocationTargetException e) {
					e.printStackTrace();
		}
	
	}
	
	/**
	 * Agrega los m�todos para los dos botones de salir y Ejecutar
	 */
	private void addActions() {
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
			 });
			 
		enviar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
 					
				final Thread doInterpretar = new Thread() {
					public void run() {
						String texto;
						String resp;
						orden.setEditable(false);
						enviar.setEnabled(false);
						printOutput("USER  INPUT: " + orden.getText()+"\n");
						texto=orden.getText();
						orden.setText("");
						commands.addElement(texto);
						contCom = commands.size();
						resp=interpreter.process(texto);
						orden.setEditable(true);
						orden.setEnabled(true);
						enviar.setEnabled(true);
						printOutput(resp);
					}
				};
				doInterpretar.start();
			}
		}); 
	}

	void orden_keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

	    //up
		if (keyCode==38){
			if (contCom>0){
				orden.setText( (commands.elementAt(contCom-1)).toString() );
				contCom=contCom-1;
			}
		}

		//down
		if (keyCode==40){
			if (contCom < commands.size()-1 ){
				orden.setText( (commands.elementAt(contCom+1)).toString() );
				contCom=contCom+1;
			}
		}

	}
	
	
	/**
	 * Crea un control de tipo Console con su correspondiente visualizacion
	 * Para ello debe crear un Frame, ubicarlo en la pantalla y hacerlo
	 * visible. Todo eso se hace aqui
	 * Recibe un argumento cuando se ejecuta, que corresponde a las dimensiones
	 * del mundo
	 * Es decir que para llamar la aplicacion se debe hacer
	 * <pre>java interfaz.console 8</pre>
	 * Reemplazando 8 por el numero de casillas del mundo
	 */

	public static void main(String args[]) {
		//Si no hay exactamente un argumento o no es un numero debe mandar un
		//mensaje

		int size=0;
		int iniX=1,iniY=1, iniGlobos=1, iniFichas=1;
	  
		
		try {
	    if (args.length == 0) {
				size=  8;
				iniX = 1;
				iniY = 1;
				iniGlobos = 100;
				iniFichas = 64;
	    }
	   else if (args.length != 5) {
			throw new Exception("Expeccting five arguments");
	    }
	    else {
			size= Integer.parseInt(args[0]);
			iniX = Integer.parseInt(args[1]);
			iniY = Integer.parseInt(args[2]);
			iniGlobos = Integer.parseInt(args[3]);
			iniFichas = Integer.parseInt(args[4]);
			if(iniX<1 || iniX>size) throw new Exception("La posicion inicial delrobot en X debe estar dentro del mundo" );
			if(iniY<1 || iniY>size) throw new Exception("La posicion inicial delrobot en Y debe estar dentro del mundo" );
			if(iniGlobos < 0) throw new Exception("El n�mero de globos debe ser positivo" );
			if(iniY<1 || iniY>size) throw new Exception("El n�mero de fichas debe ser positivo" );
		} 
	    }
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage()+"\nUso: java interfaz.console <numCasillas> <X inicial robot> <Y inicial Robot>");
			System.exit(1);
		}
	
		frame = new JFrame("Robot World");
		/* Hace que la aplicaci�n salga cuando se cierra esta ventana*/
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }  
        });
		 
		board = new Board(new RobotWorldDec(size, new Point(iniX,iniY),iniGlobos, iniFichas));
		console = new Console(board.getWorld());
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(board);
		frame.getContentPane().add(console,BorderLayout.SOUTH);
		
		frame.pack();
		
	    //Center the window
		Dimension frameSize = frame.getSize();
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	 }

	
	
/**
 * 
 * @author Silvia Takahashi
 *
 * Clase para poder ejecutar sincr�nicamente los cambios en el 
 * Panel de system
 * 
 */
class OutputPrinter implements Runnable {

	String message;
	
	public OutputPrinter() {
	}
	public void run() {
				system.append(message);		
	}
	public void setMessage(String s) {
	 	message = s;
	 }
}

class KeyAdapter extends java.awt.event.KeyAdapter {
  
  Console adaptee;

  KeyAdapter(Console adaptee) {
    this.adaptee = adaptee;
  } 
  
  public void keyPressed(KeyEvent e) {
    adaptee.orden_keyPressed(e);
  }
 
}


}
