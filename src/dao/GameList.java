package dao;

import java.util.Comparator;
import java.util.PriorityQueue;

import models.Game;
import structure.Node;
import structure.SimpleList;

public class GameList {

	private SimpleList<Game> games;
	private PriorityQueue<Game> priority;
	
	public GameList() {
		priority = new PriorityQueue<>(new Comparator<Game>() {

			@Override
			public int compare(Game o1, Game o2) {
				return (int) (o2.getPrice() - o1.getPrice());
			}
		});
		games = new SimpleList<>();
	}
	
	public void addGame(Game game){
		games.add(game);
	}
	
	public void deleteGame(Game game){
		games.delete(game);
	}
	
	public String randomConsole() {
		int n = (int) (Math.random()*2);
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
	
	public void addPriority() {
		Node<Game> head = games.getHead();
		while(head!=null) {
			priority.add(head.getInformation());
			head = head.getNext();
		}
		
	}

	public PriorityQueue<Game> getPriority() {
		return priority;
	}

	public SimpleList<Game> getGames() {
		return games;
	}
	
	
	
	
}
