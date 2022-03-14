 
/**
* Clase Consola
* @author Silvia Takahashi
*/

package uniandes.teolen.parserJavaCC.interfaz;


import javax.swing.*;

import uniandes.teolen.parserJavaCC.mundoParser.MundoParsers;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



public class ConsolaParsers extends JPanel{

	/* para las extensiones debe cambiar la inicialización de autos que ahora están amarradas a FraseAceptable(i) */
	
	/**
	 * El Interprete al que esta consola da ordenes
	 */
	static private MundoParsers mundo;
	
	/**
	 * El area de texto que se usa para mostrar que automata se esta usando
	 */
	static private JLabel title =  new JLabel();
	
	//The Vector of commands for history
  	static Vector <String> commands = new Vector<String> ();

  	//The number of commands
  	static int contCom = 0;	
	
	/**
	 * El area de texto que se usa para los mensajes del sistema
	 */
	static private JTextArea sistema =  new JTextArea(10,50);
	
	/**
	 * El campo de texto en el que el usuario puede escribir mensajes para que
	 * la consola los interprete
	 */
	static private JTextArea orden = new JTextArea(2,50);
	
	/**
	* Boton para enviar texto al interprete
	*/
	static private JButton enviar = new JButton("Enviar");
	
	/**
	* Boton para Salir
	*/
	static private JButton salir = new JButton("Salir");

	/** 
	* ScrollPanes para que  el log y la entrada se pueda mostrar con ScrollBars
	*/ 
        
	static private JScrollPane scrollPaneSistema = new JScrollPane(sistema);
	static private JScrollPane scrollPaneOrden = new JScrollPane(orden);

	/**
	 * Runnable class para controlar el flujo de ejecución al escribir en la
	 * ventana del sistema
	 */
	
	final OutputPrinter escribirEnSistema = new OutputPrinter();
	
	/* Menu */
	private JMenuBar mb;

	
	static private ConsolaParsers consola;
	static private JFrame frame;
	/**
	 * Crea una nueva consola que se encarga de dar ordenes a un determinado
	 * mundo a traves de un Interprete
	 * @param mundo El mundo al que esta consola manejara
	 */
	
	public ConsolaParsers(MundoParsers mp) {
		
		mundo = mp;
		
	    orden.addKeyListener(new KeyAdapter(this));
		
	    agregarAcciones();
		
		//El log no se debe poder modificar
		sistema.setEditable(false);
		//title.setEditable(false);
		title.setText(mundo.getStringCurrentParser());
		title.setHorizontalAlignment(SwingConstants.CENTER);
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
		gridBag.setConstraints(scrollPaneSistema,c);
        
		c.weightx =1.0;
        c.weighty = 1.0;
        gridBag.setConstraints(title,c);
        
        add(title);
        c.fill = GridBagConstraints.HORIZONTAL;
        gridBag.setConstraints(scrollPaneSistema,c);
        add(scrollPaneSistema);
        gridBag.setConstraints(scrollPaneOrden,c);
        add(scrollPaneOrden);
        add(enviar);
     	add(salir);
     	initMenu();
     	frame.setJMenuBar(mb);
     	
   }
	
public static void relaunch(int dim){
		
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
	 * Ejecuta sincrónicamente la orden de escrbir en TextArea sistema
	 * @param msg
	 */
	
	private void imprimirSalida(String msg) {
	    
		escribirEnSistema.setMessage(msg);
		try {
			SwingUtilities.invokeAndWait(escribirEnSistema);
		} catch (InterruptedException e) {
					e.printStackTrace();
		} catch (InvocationTargetException e) {
					e.printStackTrace();
		}
	
	}
	
	/**
	 * Agrega los métodos para los dos botones de salir y Ejecutar
	 */
	private void agregarAcciones() {
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
						String resp = null;
						orden.setEditable(false);
						enviar.setEnabled(false);
						imprimirSalida("Usuario: \n" + orden.getText()+"\n");
						texto=orden.getText();
						orden.setText("");
						commands.addElement(texto);
						contCom = commands.size();
						
						resp = mundo.procesarCadena(texto);
						
						orden.setEditable(true);
						orden.setEnabled(true);
						enviar.setEnabled(true);
						imprimirSalida(resp);
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
	
	private void setParser(int p) {
		mundo.setCurrentParser(p);
		title.setText(mundo.getStringCurrentParser());
		title.repaint();
		//sistema.cut();
		sistema.setText("");
		sistema.repaint();
	}
	
	private void initMenu() {
		  
  		mb = new JMenuBar();
  		
  		JMenu menuAyuda = new JMenu("Ayuda");
  		JMenu menuParser = new JMenu("Parser");
  		
  		for (int i = 0; i < mundo.sizeParsers() ; i++) {
        	final int parser = i; 
        	JMenuItem itemP =  new JMenuItem(mundo.getParser(i));
        	 
        	itemP.addActionListener(new ActionListener() {
      			  public void actionPerformed(ActionEvent e) {
      					setParser(parser);
      				}
        		 }
      		   );
        	menuParser.add(itemP);
  		}
  		
  		
  		JMenuItem itemAbout = new JMenuItem("Acerca De...");
  		menuAyuda.add(itemAbout);
	
		mb.add(menuParser);
		mb.add(menuAyuda);
		
		menuAyuda.add(itemAbout);
		itemAbout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MessageDialog m = new MessageDialog();
				m.showMessage("About...","Probador de Autómatas");
			}
		});
		
		frame.setJMenuBar(mb);
	}
		


	
	
	/**
	 * Crea un control de tipo Consola con su correspondiente visualizacion
	 * Para ello debe crear un Frame, ubicarlo en la pantalla y hacerlo
	 * visible. 
	 * 	 */

	public static void main(String args[]) {
		//Si no hay exactamente un argumento o no es un numero debe mandar un
		//mensaje

		
		
		try {
	    if (args.length != 0) {
			throw new Exception("No Debe haber  argumentos");
	    }
	   
	    }
		catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage()+"\nUso: java interfaz.Consola <numCasillas> <X inicial robot> <Y inicial Robot>");
			System.exit(1);
		}
	
		frame = new JFrame("Probador de Parsers");
		/* Hace que la aplicación salga cuando se cierra esta ventana*/
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }  
        });
		
		consola = new ConsolaParsers(new MundoParsers());
		
		//Hace que lo que hay en el archivo se pueda mover con barras
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(consola);
		frame.setSize(100, 100);
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
 * 
 * @author Silvia Takahashi
 *
 * Clase para poder ejecutar sincrónicamente los cambios en el 
 * Panel de sistema
 * 
 */
class OutputPrinter implements Runnable {

	String message;
	
	public OutputPrinter() {
	}
	public void run() {
				sistema.append(message);		
	 }
	 public void setMessage(String s) {
	 	message = s;
	 }
}

class KeyAdapter extends java.awt.event.KeyAdapter {
  
  ConsolaParsers adaptee;

  KeyAdapter(ConsolaParsers adaptee) {
    this.adaptee = adaptee;
  } 
  
  public void keyPressed(KeyEvent e) {
    adaptee.orden_keyPressed(e);
  }
 
}
}
