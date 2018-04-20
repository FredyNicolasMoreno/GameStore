package models;

public class Customer {

	private int id, age, x, y;
	private String name;

	public Customer(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Customer(int id, String name, int age, int x, int y ) {
		super();
		this.id = id;
		this.age = age;
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
