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
	
	public int randomPrice() {
		return (int)((Math.random()*240000)+90000);
	}
	
	public String randomGameName() {
		
		int n = (int) (Math.random()*10)+1; 
		String[] names = {"","NieR: Automata","PLAYERUNKNOWN'S BATTLEGROUNDS","Far Cry® 5","Dying Light Enhanced Edition","BATTLETECH",
				"Rocket League®","The Elder Scrolls V: Skyrim Special Edition","Rise of the Tomb Rider","PC Building Simulator","Counter-Strike: Global Offensive"};
		return names[n];
		
	}
}
