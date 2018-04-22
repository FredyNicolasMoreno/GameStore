package dao;

import models.Game;
import structure.SimpleList;

public class GameList {

	private SimpleList<Game> games;
	
	public GameList() {
		
		games = new SimpleList<>();
	}
	
	public void addGame(Game game){
		games.add(game);
	}
	
	public void deleteGame(Game game){
		games.delete(game);
	}
	
	public String randomConsole() {
		int n = (int) (Math.random()*3);
		String[] consoles = {"PC","Xbox","PlayStation"};
		return consoles[n];
	}
}
