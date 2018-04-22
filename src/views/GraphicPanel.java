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
//				g.setColor(Color.BLACK);
//				g.drawImage(new ImageIcon("/src/img/silhouette").getImage(), current.getInformation().getX(), current.getInformation().getY(), 60, 60, this);
				paintHumans(g, currentCustomer);
//				g.setColor(Color.decode("#FFFF0D"));
				currentCustomer = currentCustomer.getNext();
			}
		}
		if(listGames != null) {
			Node<Game> currentGame = listGames.getHead();
			while (currentGame!=null) {
				paintGames(g, currentGame);
				currentGame = currentGame.getNext();
			}
		}else{
//			System.out.println("Nula");
		}
		g.setColor(Color.RED);
		g.fillRect(250, 0, 50, 550);
		g.fillRect(0, 500, 250, 50);
	}
	
	public void paintHumans(Graphics g, Node<Customer> current){
		g.fillOval(current.getInformation().getX(), current.getInformation().getY(), 60, 60);
	}
	
	public void paintGames(Graphics g, Node<Game> current) {
		g.fillRect(current.getInformation().getX(), current.getInformation().getY(), 20, 15);
	}
	
	public void setList(Queue<Customer> list){
		this.customersQueue = list;
	}
	
	public void setGamesList(SimpleList<Game> games) {
		this.listGames = games;
	}
	
}
