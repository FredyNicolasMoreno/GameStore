package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import models.Customer;
import models.Game;
import structure.Queue;
import structure.SimpleList;
import views.MainWindow;

public class Control implements ActionListener{

	private Queue<Customer> customers;
	private SimpleList<Game> games;
	private MainWindow window;
	
	
	public Control() {
		customers = new Queue<Customer>();
		games = new SimpleList<Game>();
		window = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case START:
			startSimulation();
			window.setList(customers);
			move();
			break;

		default:
			break;
		}
		
	}
	
	public void move() {
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.move();
			}
		});
		timer.start();
	}
	
	public void startSimulation(){
		fillCustomerRow();
		fillGameStack();
	}
	
	public void fillGameStack() {
		for (int i = 0; i < 10; i++) {
			games.add(new Game(i, "Game", "console", 0, 300));
		}
		
	}
	
	public void fillCustomerRow(){
		
		for (int i = 0; i < 10; i++) {
			customers.enqueue(new Customer(i, "Juan", 21,0,50));
		}
		
	}
	
}
