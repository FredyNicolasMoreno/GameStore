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
		
}