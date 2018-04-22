package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.GameList;
import models.Customer;
import models.Game;
import structure.Queue;
import structure.SimpleList;
import views.MainWindow;

public class Control implements ActionListener{

	private Queue<Customer> customers;
	private SimpleList<Game> games;
	private GameList gameList;
	private MainWindow window;
	
	
	public Control() {
		customers = new Queue<Customer>();
		gameList = new GameList();
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
		int y = 50;
		for (int i = 0; i < quantity; i++) {
			games.add(new Game(i, "Game", randomConsole(), randomPrice(), 0, y+=20));
		}
		if(games==null) {
			fillGameStack(quantity);
			
		}
		
	}
	
	private int randomPrice() {
		return gameList.randomPrice();
	}

	public void reFillGames() {
		
	}
	
	public void fillCustomerRow(int quantity){
		int x = 250;
		for (int i = 0; i < quantity; i++) {
			customers.enqueue(new Customer(i, "Juan", 21,x+=70,50));
		}
	}
	
	private String randomConsole() {
		return gameList.randomConsole();
	}
	
}
