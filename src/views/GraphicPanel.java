package views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import models.Customer;
import structure.Node;
import structure.Queue;

public class GraphicPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Queue<Customer> listCustomers;
	
	public GraphicPanel() {
		setBackground(Color.WHITE);
		listCustomers = new Queue<Customer>();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(listCustomers != null){
			Node<Customer> current = listCustomers.getHead();
			while (current!=null) {
//				g.setColor(Color.BLACK);
//				g.drawImage(new ImageIcon("/src/img/silhouette").getImage(), current.getInformation().getX(), current.getInformation().getY(), 60, 60, this);
				paintHumans(g, current);
//				g.setColor(Color.decode("#FFFF0D"));
				current = current.getNext();
			}
		}
		g.setColor(Color.RED);
		g.fillRect(250, 0, 50, 550);
		g.fillRect(0, 500, 250, 50);
	}
	
	public void paintHumans(Graphics g, Node<Customer> current){
		g.fillOval(current.getInformation().getX(), current.getInformation().getY(), 60, 60);
	}
	
	public void setList(Queue<Customer> list){
		this.listCustomers = list;
	}
}
