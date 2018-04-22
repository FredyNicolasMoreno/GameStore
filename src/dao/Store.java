package dao;

import models.Customer;
import models.Game;
import models.Sale;
import structure.Queue;
import structure.SimpleList;

public class Store {

	private Queue<Customer> customerQueue;
	private SimpleList<Game> gameList;
	private SimpleList<Sale> sales;
	
	public void attendCustomer() throws Exception {
		sales.add(new Sale(customerQueue.dequeue().getInformation(), gameList.getHead().getInformation()));
	}
	
}
