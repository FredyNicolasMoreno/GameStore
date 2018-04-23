package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import dao.CustomerQueue;
import dao.GameList;
import dao.Store;
import models.Customer;
import models.Game;
import structure.Node;
import structure.Queue;
import structure.SimpleList;
import views.GamesTable;
import views.MainWindow;
import views.MostExpensiveTable;
import views.MostSoldConsole;

public class Control implements ActionListener{

	private Queue<Customer> customers;
	private CustomerQueue customer;
	private Timer attend;
	private GameList gameList;
	private Store store;
	private MainWindow window;
	private GamesTable gTable;
	private MostExpensiveTable expTable;
	private MostSoldConsole mvTable;
	
	
	public Control() {
		customers = new Queue<Customer>();
		customer = new CustomerQueue();
		gameList = new GameList();
		store = new Store();
		window = new MainWindow(this);
		gTable = new GamesTable(this);
		expTable = new MostExpensiveTable(this);
		mvTable = new MostSoldConsole(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case START:
			store.setCustomersList(customers);
			store.setList(gameList.getGames());
			window.setList(customers);
			window.setGameList(gameList.getGames());
			startSimulation();
			break;
		case STOP:
			attend.stop();
			break;
		case GAMES_REPORT:
			report();
			break;
		case EXPENSIVE:
			mostExpensive();
			break;
		case BEST_SELLER:
			bestSeller();
			break;
		default:
			break;
		}
		
	}
	
	
	private void bestSeller() {
		mvTable.refreshTable(store.salesList());
		mvTable.setVisible(true);
	}

	private void mostExpensive() {
		gameList.addPriority();
		expTable.refreshTable(gameList.getPriority());
		expTable.setVisible(true);
		
	}

	private void report() {
		gTable.refreshTable(store.salesList());
		gTable.setVisible(true);
	}

	public void startSimulation(){
		if(window.getCustomersAmount()==0) {
			window.errorDialog("Necesita tener por lo menos un cliente");
		}else if(window.getGamesAmount()==0) {
			window.errorDialog("Necesita tener por lo menos un juego");
		}
		fillCustomerRow(window.getCustomersAmount());
		fillGameStack(window.getGamesAmount());
		attendClient();
	}
	
	private void attendClient() {
		attend = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attend();
			}
		});
		attend.start();
	}
	
	public void attend() {
		Node<Customer> current = customers.getHead();
		while(current!=null) {
			store.attendCustomer(current);
			current = current.getNext();
		}
		window.setGameList(gameList.getGames());
		window.setList(customers);
	}

	public void fillGameStack(int quantity) {
		int y = 50;
		for (int i = 0; i < quantity; i++) {
			gameList.addGame(new Game(i, randomName(), randomConsole(), randomPrice(), 0, y+=20));
		}
		if(gameList.getGames()==null) {
			fillGameStack(quantity);
		}
		
	}
	
	private String randomCustomerName() {
		return customer.randomName();
	}
	
	private int randomPrice() {
		return gameList.randomPrice();
	}
	
	private String randomName() {
		return gameList.randomGameName();
	}

	public void reFillGames() {
		
	}
	
	public void fillCustomerRow(int quantity){
		int x = 250;
		for (int i = 0; i < quantity; i++) {
			customers.enqueue(new Customer(i, randomCustomerName(), 21,x+=70,50));
		}
	}
	
	private String randomConsole() {
		return gameList.randomConsole();
	}
	
}
