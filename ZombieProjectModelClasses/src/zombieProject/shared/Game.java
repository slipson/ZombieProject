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
	




	private Player player;
	ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
	ArrayList<Spawned> spawnList = new ArrayList<Spawned>();
	ArrayList<Ammo> AmmoList = new ArrayList<Ammo>();
	ArrayList<Obstacle> obsList = new ArrayList<Obstacle>();



	
	/**
	 * game constructor
	 */
	public Game() {
		this.player = new Player(50, 50);
		this.zombieList.add(new Zombie(1, 1));
	}





	Random generator = new Random();



	public Player getPlayer() {
		return player;
	}
	
	public Zombie getZombie(int i) {
		return zombieList.get(i);
	}
	
	public Spawned getSpawned(int i) {
		return spawnList.get(i);
	}
	
	public Ammo getAmmo(int i) {
		return AmmoList.get(i);
	}
	
	public void newZombie(){
		int x = generator.nextInt(294);
		int y = generator.nextInt(144);
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
		int x = generator.nextInt(294);
		int y = generator.nextInt(144);
		this.spawnList.add(new Spawned(x, y));
	}

	public void removeS(int i){
		this.spawnList.remove(i);
	}
	
	
	public int AmmoSize(){
		return AmmoList.size();
	}
	
	public void newAmmo(){
		int x = generator.nextInt(294);
		int y = generator.nextInt(144);
		this.AmmoList.add(new Ammo(x, y));
	}

	public void removeA(int i){
		this.AmmoList.remove(i);
	}
	
	
	public int obsSize(){
		return obsList.size();
	}
	
	public void newobs(){
		int x = generator.nextInt(200)+25;
		int y = generator.nextInt(100)+25;
		int size = generator.nextInt(20)+5;
		this.obsList.add(new Obstacle(x, y, size));
	}
	
	public Obstacle getObs(int i) {
		return obsList.get(i);
	}
}

