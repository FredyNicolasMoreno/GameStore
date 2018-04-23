package dao;

import models.Customer;
import structure.Queue;

public class CustomerQueue {

	private Queue<Customer> customers;
	
	public CustomerQueue() {
		customers = new Queue<Customer>();
	}
	
	
	public void addCustomer(Customer customer) {
		customers.enqueue(customer);
	}
	
	public void deleteCustomer() throws Exception {
		customers.dequeue();
	}
	
	public String randomName() {
		
		int n = (int) (Math.random()*20)+1; 
		String[] names = {"","Babara","Natalie","Jolynn","Alejandro","Nicholas","Cedric","Lana","Sasha","Charlotte","Seth",
				"Matt","Jeff","Natalya","Becky","Alexa","Bray","Roman","Dean","Sofia","Angie"};
		return names[n];
	}
	
}