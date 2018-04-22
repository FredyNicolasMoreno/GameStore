package views;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class ErrorDialog extends JDialog{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorDialog(String error) {
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel panel = new JLabel(error);
		add(panel, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
}
