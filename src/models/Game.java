package models;

public class Game {

	private int id;
	private String name, console;
	private int x,y;
	
	public Game(int id, String name, String console) {
		this.id = id;
		this.name = name;
		this.console = console;
	}
	
	public Game(int id, String name, String console, int x, int y) {
		super();
		this.id = id;
		this.name = name;
		this.console = console;
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
