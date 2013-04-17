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
	
	private int x_bullet = 0; // x direction of the bullet
	private int y_bullet = 0; // y direction of the bullet
	Map m = new Map();

	/**
	 * updates the game state
	 * @param game the game object
	 */
	public void updateGame(Game game){
		
		//checks all of zombie collisions
		for(int i = 0; i < this.zombieList.size(); i++){
			this.zombieList.get(i);
			
			//if zombie is within map boundaries, check that the zombie is not colliding with other zomibes
			if(this.zombieList.get(i).canMove(m)){
				boolean moveable = this.zombieList.get(i).checkZombieCollisions(this.zombieList);
			}
		}
		
	}

	/**
	 * sets the direction the bullet will move
	 * @param x bullet's x direction
	 * @param y bullet's y direction
	 */
	public void setBulletDirection(int x, int y){
		this.x_bullet = x;
		this.y_bullet = y;
	}
	
	/**
	 * get the x direction of the bullet
	 * @return bullet's x direction
	 */
	public int getBullet_X(){
		return this.x_bullet;
	}
	
	/**
	 * get the y direction of the bullet
	 * @return bullet's y direction
	 */
	public int getBullet_Y(){
		return this.y_bullet;
	}
	
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