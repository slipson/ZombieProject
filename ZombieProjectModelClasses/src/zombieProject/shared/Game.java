package zombieProject.shared;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jcoady
 * 
 * The Game class is essentially the engine for this game. This class updates initializes, and updates the game state
 * which would be shown by the UI of the game. Methods in this class include getter and setter methods for the player object.
 */
public class Game {

	Random generator = new Random();

	private Player player;
//	private Zombie zombie;
	
	ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
	ArrayList<Spawned> spawnList = new ArrayList<Spawned>();


	public Game() {
		this.player = new Player(50, 50);
		this.zombieList.add(new Zombie(0, 0));
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Zombie getZombie(int i) {
		return zombieList.get(i);
	}
	
	public Spawned getSpawned(int i) {
		return spawnList.get(i);
	}
	
	public void newZombie(){
		int x = generator.nextInt(100);
		int y = generator.nextInt(100);
		this.zombieList.add(new Zombie(x, y));
	}
	
	public int listSize(){
		return zombieList.size();
	}


	

	public void removeZ(int i){
		this.zombieList.remove(i);
	}
	
	
	public int spawnSize(){
		return spawnList.size();
	}
	
	public void newSpawn(){
		int x = generator.nextInt(100);
		int y = generator.nextInt(100);
		this.spawnList.add(new Spawned(x, y));
	}

	public void removeS(int i){
		this.spawnList.remove(i);
	}
}

