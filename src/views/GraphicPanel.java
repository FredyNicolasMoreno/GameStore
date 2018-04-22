package views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import models.Customer;
import models.Game;
import structure.Node;
import structure.Queue;
import structure.SimpleList;

public class GraphicPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Queue<Customer> customersQueue;
	private SimpleList<Game> listGames;
	
	
	
	public GraphicPanel() {
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(customersQueue != null){
			Node<Customer> currentCustomer = customersQueue.getHead();
			while (currentCustomer!=null) {
				paintHumans(g, currentCustomer);
				currentCustomer = currentCustomer.getNext();
			}
		}
		if(listGames != null) {
			Node<Game> currentGame = listGames.getHead();
			while (currentGame!=null) {
				paintGames(g, currentGame);
				currentGame = currentGame.getNext();
			}
		}
		
		g.setColor(Color.RED);
		g.fillRect(250, 0, 50, 550);
	}
	
	public void paintHumans(Graphics g, Node<Customer> current){
		g.setColor(Color.decode("#E89375"));
		g.fillOval(current.getInformation().getX(), current.getInformation().getY(), 60, 60);
	}
	
	public void paintGames(Graphics g, Node<Game> current) {
		if(current.getInformation().getConsole().equals("PC")) {
			g.setColor(Color.GRAY);
		}else if(current.getInformation().getConsole().equals("Xbox")){
			g.setColor(Color.GREEN);
		}else {
			g.setColor(Color.BLUE);
		}
		g.fillRect(current.getInformation().getX(), current.getInformation().getY(), 20, 15);
	}
	
	public void setList(Queue<Customer> list){
		this.customersQueue = list;
	}
	
	public void setGamesList(SimpleList<Game> games) {
		this.listGames = games;
	}
	
}
