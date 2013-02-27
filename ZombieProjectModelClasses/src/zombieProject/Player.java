package zombieProject;

public class Player{

	private int x; //player's x coordinate
	private int y; //player's y coordinate
	
	private Weapon weapon; //player's current weapon
	
	private double health; //player's health
	
	/**
	 * player constructor
	 * 
	 * @param x initial x-coordinate
	 * @param y initial y-coordinate
	 */
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		
		this.health = 100;
	}
	
	/**
	 * returns player's x-coordinate
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * set player's x-coordinate
	 * 
	 * @param x new x-coordinate
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * returns player's y-coordinate
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * set player's y-coordinate
	 * 
	 * @param d new y-coordinate 
	 */
	public void setY(int d){
		this.y = d;
	}
	
	/**
	 * increase the players health
	 * 
	 * @param val the amount to be added to player's health
	 */
	public void increaseHealth(double val){
		this.health += val;
	}
	
	/**
	 * decreases the player's health
	 * 
	 * @param val the amounte to be removed from player's health
	 */
	public void decreaseHealth(double val){
		this.health -= val;
	}
	
	/**
	 * returns the player's health
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * boolean to determine whether player can move to new coordinates
	 * 
	 * @param z the zombie
	 * 
	 * @return false = player CANNOT move, true = player CAN move
	 */
	public boolean canMove(Zombie z){
		
		//if player's next move is a zombie location, player cannot move there.
		if(this.x + 1 == z.getX() || this.x - 1 == z.getX() || this.y + 1 == z.getY() || this.y - 1 == z.getY()){
			return false;
		}else{
			return true;
		}
		
	}
	/**
	 * player attacks an enemy and inflicts damage
	 * 
	 * @param weapon currently used weapon
	 */
	public int inflictDamage(Weapon weapon){
		
		return weapon.getdamage();
		
	}
	
	
}
