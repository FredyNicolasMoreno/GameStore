package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import models.Customer;
import structure.Node;
import structure.Queue;

public class GraphicPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Customer customer;
	private Queue<Customer> listCustomers;
	
	public GraphicPanel() {
		setBackground(Color.WHITE);
		listCustomers = new Queue<Customer>();
	}
	
	@Override
	public void paint(Graphics g) {
		int x = 0;
		int y = 50;
		if(listCustomers != null){
			Node<Customer> current = listCustomers.getHead();
			while (current!=null) {
//				g.setColor(Color.BLACK);
				g.fillOval(x, y, 60, 60);
//				g.setColor(Color.decode("#FFFF0D"));
				g.fillOval(x+10, y+10, 40, 40);
				current = current.getNext();
				x += 70;
			}
		}
		
	}
	
	public void paintHumans(Graphics g, int x, int y){
		
	}
	
	public void setList(Queue<Customer> list){
		this.listCustomers = list;
	}
}
