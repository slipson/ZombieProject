package zombieProject;

public class Player extends Game{

	private int x; //player's x coordinate
	private int y; //player's y coordinate
	
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
		
		health = 100;
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
	 * @param y new y-coordinate 
	 */
	public void setY(int y){
		this.y = y;
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
		if(this.x + 1 >= z.getX() || this.x - 1 <= z.getX() || this.y + 1 >= z.getY() || this.y - 1 <= z.getY()){
			return false;
		}else{
			return true;
		}
		
	}
	
//	/**
//	 * move the player according to it's x-, y- coordinates
//	 * 
//	 * @param x player's x-coordinate
//	 * @param y player's y-coordinate
//	 * 
//	 */
//	private void move(boolean canMove, /*button?*/){
//		
//		if(canMove == true){
//			
//			if(/*push left button*/){
//				
//				x++;
//				
//			}else if(/*push right button*/){
//				
//				x--;
//				
//			}else if(/*push up button*/){
//				
//				y--;
//				
//			}else if(/*push down button*/){
//				
//				y++;
//				
//			}
//			
//		}
//	
//	}
	
}
