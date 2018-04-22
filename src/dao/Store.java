package dao;

import models.Customer;
import models.Game;
import models.Sale;
import structure.Node;
import structure.Queue;
import structure.SimpleList;

public class Store {

	private Queue<Customer> customerQueue;
	private GameList list;
	private SimpleList<Game> gameList;
	private SimpleList<Sale> sales;
	
	public void attendCustomer() {
		Game game = getRandomGame();
		if(game == null) {
			requestNewGame(game);
		}
		sales.add(new Sale(customerQueue.dequeue().getInformation(), game));
	}
	
	public Game getRandomGame() {
		Node<Game> actual = gameList.getHead();
		String console = list.randomConsole();
		if (actual.getInformation().getConsole() != console) {
			while (actual.getNext() != null) {
				if (actual.getInformation().getConsole() != console) {
					actual = actual.getNext();
				}else{
					return actual.getInformation();
				}
			}
		}
		return actual.getInformation();
	}
	
	public void requestNewGame(Game game) {
		list.addGame(game);
	}
	
}
