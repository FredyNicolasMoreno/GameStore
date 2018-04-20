package views;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import models.Customer;
import structure.Queue;
import controller.Actions;
import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private GraphicPanel g;
	
	public MainWindow(Control control) {

		setTitle("GameStore Simulator");
		setIconImage(new ImageIcon("src/img/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		g = new GraphicPanel();
		add(g);
		
		JButton start = new JButton("Start");
		start.addActionListener(control);
		start.setActionCommand(Actions.START.toString());
		add(start, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public void setList(Queue<Customer> list){
		g.setList(list);
		g.revalidate();
		g.repaint();
	}
	
}
