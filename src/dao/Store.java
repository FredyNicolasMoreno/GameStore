package dao;

import models.Customer;
import models.Game;
import models.Sale;
import structure.Node;
import structure.Queue;
import structure.SimpleList;

public class Store {

	private GameList list;
	private SimpleList<Game> gameList;
	private SimpleList<Sale> sales;
	private Queue<Customer> customers;
	
	public Store() {
		sales = new SimpleList<>();
		list = new GameList();
	}
	
	public void attendCustomer(Node<Customer> customer) {
		Game game = getRandomGame();
		if(game == null) {
			requestNewGame(game);
		}
		sales.add(new Sale(customers.dequeue().getInformation(), game));
	}
	
	public Game getRandomGame() {
		Node<Game> actual = gameList.getHead();
		String console = list.randomConsole();
		if (actual.getInformation().getConsole() != console) {
			while (actual != null) {
				if (actual.getInformation().getConsole() != console) {
				}else{
					return actual.getInformation();
				}
				actual = actual.getNext();
			}
		}
		return actual.getInformation();
	}
	
	public void requestNewGame(Game game) {
		list.addGame(game);
	}

	public void setList(SimpleList<Game> gameList) {
		this.gameList = gameList;
	}
	
	public void setCustomersList(Queue<Customer> customerList) {
		this.customers = customerList;
	}

	public SimpleList<Sale> salesList(){
		return sales;
	}
	
	
	
	public int[] sortByConsole(){
		Node<Sale> actual = sales.getHead();
		int pcCount = 0;
		int xBoxCount = 0;
		int pSCount = 0;
		
		while(actual.getNext()!=null) {
			if(actual.getInformation().getGame().getConsole().equals("PC")) {
				pcCount++;
			}else if(actual.getInformation().getGame().getConsole().equals("Xbox")) {
				xBoxCount++;
			}else if(actual.getInformation().getGame().getConsole().equals("PlayStation")) {
				pSCount++;
			}
			actual = actual.getNext();
		}
		int[] sortedList = new int[] {pcCount,xBoxCount,pSCount};
		return sortedList;
	}
}
