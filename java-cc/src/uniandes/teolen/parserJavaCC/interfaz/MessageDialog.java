package uniandes.teolen.parserJavaCC.interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MessageDialog extends JDialog {

	private JLabel message = new JLabel("");	
	private JButton bOK = new JButton("OK");

	public MessageDialog() {
		super();
		setModal(true);
		bOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					    setVisible(false);						
					}
			});
		getContentPane().setLayout(new GridLayout(2,1));
		getContentPane().add(message);
		getContentPane().add(bOK);
		pack();
			
	}

	public void showMessage(String titulo, String msg) {
		setTitle(titulo);
		message.setText(msg);
		pack();
		setVisible(true);
	}	
}
