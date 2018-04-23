package views;




import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import models.Customer;
import models.Game;
import structure.Queue;
import structure.SimpleList;
import controller.Actions;
import controller.Control;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;

	private GridSystem grid;
	private GraphicPanel g;
	private JSpinner spinnerGames, spinnerCustomers;
	
	public MainWindow(Control control) {

		grid = new GridSystem(this);
		grid.addExternalBorder(10, 10, 10, 10);
		
		setTitle("GameStore Simulator");
		setMinimumSize(new Dimension(800, 400));
		setIconImage(new ImageIcon("src/img/icon.png").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		g = new GraphicPanel();
		add(g, grid.insertComponent(0, 0, 0, 1));
		
		JLabel games = new JLabel("Games");
		add(games, grid.insertComponent(9, 0, 1, 0));
		
		spinnerGames = new JSpinner();
		add(spinnerGames, grid.insertComponent(10, 0, 1, 0));
		
		JLabel customers = new JLabel("Customers");
		add(customers, grid.insertComponent(11, 0, 1, 0));
		
		spinnerCustomers = new JSpinner();
		add(spinnerCustomers, grid.insertComponent(12, 0, 1, 0));
		
		JButton start = new JButton("Start");
		start.addActionListener(control);
		start.setActionCommand(Actions.START.toString());
		start.setBorderPainted(false);
		start.setBackground(Color.decode("#5CCC01"));
		start.setForeground(Color.decode("#CC3908"));
		add(start, grid.insertComponent(10, 1, 1, 0));
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(control);
		stop.setActionCommand(Actions.STOP.toString());
		stop.setBorderPainted(false);
		stop.setBackground(Color.decode("#5CCC01"));
		stop.setForeground(Color.decode("#CC3908"));
		add(stop, grid.insertComponent(11, 1, 1, 0));
		
		JButton gamesReport = new JButton("Reporte de Ventas");
		gamesReport.addActionListener(control);
		gamesReport.setActionCommand(Actions.GAMES_REPORT.toString());
		gamesReport.setBorderPainted(false);
		gamesReport.setBackground(Color.decode("#5CCC01"));
		gamesReport.setForeground(Color.decode("#CC3908"));
		add(gamesReport, grid.insertComponent(10, 2, 1, 0));
		
		setVisible(true);
	}

	public void setList(Queue<Customer> list){
		g.setList(list);
		g.repaint();
	}
	
	public void setGameList(SimpleList<Game> games) {
		g.setGamesList(games);
		g.repaint();
	}
	
	public int getCustomersAmount() {
			return (int)spinnerCustomers.getValue();
	}
	
	public int getGamesAmount() {
		return (int)spinnerGames.getValue();
	}
	
	public void errorDialog(String message) {
		ErrorDialog error = new ErrorDialog(message);
		error.setVisible(true);
	}
	
}
