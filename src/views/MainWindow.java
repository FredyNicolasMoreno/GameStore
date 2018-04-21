package views;




import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import models.Customer;
import structure.Queue;
import controller.Actions;
import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private GridSystem grid;
	private GraphicPanel g;
	
	public MainWindow(Control control) {

		grid = new GridSystem(this);
		grid.addExternalBorder(10, 10, 10, 10);
		
		setTitle("GameStore Simulator");
		setIconImage(new ImageIcon("src/img/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		g = new GraphicPanel();
		add(g, grid.insertComponent(0, 0, 0, 1));
		
		JLabel games = new JLabel("Games");
		add(games, grid.insertComponent(9, 0, 1, 0));
		
		JSpinner spinnerGames = new JSpinner();
		add(spinnerGames, grid.insertComponent(10, 0, 1, 0));
		
		JLabel customers = new JLabel("Customers");
		add(customers, grid.insertComponent(11, 0, 1, 0));
		
		JSpinner spinnerCustomers = new JSpinner();
		add(spinnerCustomers, grid.insertComponent(12, 0, 1, 0));
		
		JButton start = new JButton("Start");
		start.addActionListener(control);
		start.setActionCommand(Actions.START.toString());
		start.setBorderPainted(false);
		start.setBackground(Color.decode("#5CCC01"));
		start.setForeground(Color.decode("#CC3908"));
		add(start, grid.insertComponent(12, 1, 1, 0));
		
		setVisible(true);
	}
	
	public void setList(Queue<Customer> list){
		g.setList(list);
		g.revalidate();
		g.repaint();
	}
	
	public void move() {
		g.move();
	}
	
}
