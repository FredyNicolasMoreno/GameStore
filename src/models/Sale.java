package models;

import dao.Store;

public class Sale {

	private Customer customer;
	private Game game;
	private Store store;
	
	public Sale(Customer customer, Game game) {
		super();
		this.customer = customer;
		this.game = game;
	}

	@Override
	public String toString() {
		return "Sale [customer=" + customer + ", game=" + game + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public String[] getSaleVector() {
		return new String[] {customer.getName(),game.getName()};
	}
	
	public String[] getGameVector() {
		return new String[] {game.getName(),"$ "+String.valueOf(game.getPrice())};
	}
	
	
}
