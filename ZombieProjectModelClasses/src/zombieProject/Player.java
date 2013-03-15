package zombieProject;

/**
 * @author jcoady
 * 
 * The Player class implements all of the methods affecting the player object. The constructor initializes the 
 * location of the player as well as the player's health. This class also contains many getters and setters regarding 
 * the players location and health. 
 *
 */
public class Player {

	private double x; //player's x coordinate
	private double y; //player's y coordinate
	
	private double health; //player's health
	
	//constructor
	public Player(double x, double y){
		this.x = x;
		this.y = y;
		
		health = 100;
		
	}

	public double getX(){
		return x;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void increaseHealth(double val){
		this.health += val;
	}
	
	public void decreaseHealth(double val){
		this.health -= val;
	}
	
	public double getHealth() {
		return health;
	}
	
	/**
	 * boolean to determine whether player can move to new coordinates
	 * 
	 * @param player_width the width of the player's image
	 * @param player_height the height of the player's image
	 * @param z the zombie
	 * 
	 * @return false = player CANNOT move, true = player CAN move
	 */
	public boolean canMove(int player_width, int player_height, Zombie z){
		
		//if player's next move is a zombie location, player cannot move there.
		if((x + player_width) + 1 == z.getX() || x - 1 == z.getX() || (y + player_height) + 1 == z.getY() || y - 1 == z.getY()){
			
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
