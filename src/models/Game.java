package models;

public class Game {

	private int id;
	private String name, console;
	
	public Game(int id, String name, String console) {
		this.id = id;
		this.name = name;
		this.console = console;
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
	
	
	
}
