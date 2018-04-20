package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Customer;
import structure.Queue;
import views.MainWindow;

public class Control implements ActionListener{

	private Queue<Customer> customers;
	private MainWindow window;
	
	private int X_VALUE= 300;
	
	public Control() {
		customers = new Queue<Customer>();
		window = new MainWindow(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Actions.valueOf(e.getActionCommand())) {
		case START:
			startSimulation();
			window.setList(customers);
			break;

		default:
			break;
		}
		
	}
	
	public void startSimulation(){
		fillCustomerRow();
	}
	
	public void fillCustomerRow(){
		Customer client = new Customer(0, "Juan", 21,X_VALUE,50);
		Customer client1 = new Customer(1, "Carlos", 21,X_VALUE+=70,50);
		Customer client2 = new Customer(2, "Manuel", 21,X_VALUE+=70,50);
		Customer client3 = new Customer(3, "Segio", 21,X_VALUE+=70,50);
		Customer client4 = new Customer(4, "Sofia", 21,X_VALUE+=70,50);
		Customer client5 = new Customer(5, "Dario", 21,X_VALUE+=70,50);
		Customer client6 = new Customer(6, "Andres", 21,X_VALUE+=70,50);
		Customer client7 = new Customer(7, "Alejandro", 21,X_VALUE+=70,50);
		customers.enqueue(client);
		customers.enqueue(client1);
		customers.enqueue(client2);
		customers.enqueue(client3);
		customers.enqueue(client4);
		customers.enqueue(client5);
		customers.enqueue(client6);
		customers.enqueue(client7);
	}
	
}
