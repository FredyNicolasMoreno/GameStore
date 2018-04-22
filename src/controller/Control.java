package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
			window.setGameList(games);
			break;

		default:
			break;
		}
		
	}
	
	
	public void startSimulation(){
		fillCustomerRow(window.getCustomersAmount());
		fillGameStack(window.getGamesAmount());
	}
	
	public void fillGameStack(int quantity) {
		for (int i = 1; i == quantity; i++) {
			games.add(new Game(i, "Game", "console", 0, 300));
		}
		
	}
	
	public void fillCustomerRow(int quantity){
		int x = 0;
		for (int i = 1; i == quantity; i++) {
			customers.enqueue(new Customer(i, "Juan", 21,x,50));
			x++;
		}
	}
	
}
