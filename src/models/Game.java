package models;

public class Game {

	private int id, price;
	private String name, console;
	private int x,y;
	
	public Game(int id, String name, String console, int price) {
		this.id = id;
		this.name = name;
		this.console = console;
		this.price = price;
	}
	
	public Game(int id, String name, String console, int price, int x, int y) {
		this.id = id;
		this.name = name;
		this.console = console;
		this.price = price;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getConsole() {
		return console;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
