package zombieProject.shared;

import java.util.ArrayList;

/**
 * @author jcoady
 * 
 * The Game class is essentially the engine for this game. This class updates initializes, and updates the game state
 * which would be shown by the UI of the game. Methods in this class include getter and setter methods for the player object.
 */
public class Game {

	private Map m; //game map
	private Player p; //player
	private ArrayList<Zombie> zombies; // arraylist of zombies (if this is how we store zombies...)
	
	private int x_bullet = 0; // x direction of the bullet
	private int y_bullet = 0; // y direction of the bullet
	
	/**
	 * game constructor
	 */
	public Game(){
		m = new Map();
		p = new Player(0, 0);
		zombies = new ArrayList<Zombie>();
	}
	
	/**
	 * updates the game state
	 * @param game the game object
	 */
	public void updateGame(Game game){
		
		//checks all of zombie collisions
		for(int i = 0; i < zombies.size(); i++){
			Zombie zombie = zombies.get(i);
			
			//if zombie is within map boundaries, let the zombie move around
			if(zombie.canMove(m) == true){
				zombie.zMove(p);
			}
		}
		
		
	}
	
	/**
	 * returns player's x-coordinate
	 * @param p the player
	 * @return player's x-coordinate
	 */
	public double getPlayerX(){
		return p.getX();
	}
	
	/**
	 * returns player's y-coordinate
	 * @param p the player
	 * @return player's y-coordinate
	 */
	public double getPlayerY(){
		return p.getY();	
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
	
	public double getZombieX(Zombie z){
		return z.getX();
	}
	
	public double getZombieY(Zombie z){
		return z.getY();
	}
	
	public void removeZ(int i){
		this.zombieList.remove(i);
	}
	
}
