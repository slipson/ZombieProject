<<<<<<< HEAD
package zombieProject;

public class Player extends Game{

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
	
	/**
	 * boolean to determine whether player can move to new coordinates
	 * 
	 * @param x player's x coordinate
	 * @param y player's y coordinate
	 * @param z the zombie
	 * 
	 * @return false = player CANNOT move, true = player CAN move
	 */
	private boolean canMove(int x, int y, Zombie z){
		
		//if player's next move is a zombie location, player cannot move there.
		if(x + 1 == z.getX() || x - 1 == z.getX() || y + 1 == z.getY() || y - 1 == z.getY()){
			
			return false;
			
		}else{
			
			return true;
			
		}
		
	}
	
	/**
	 * move the player according to it's x-, y- coordinates
	 * 
	 * @param x player's x-coordinate
	 * @param y player's y-coordinate
	 * 
	 */
	private void move(boolean canMove, /*button?*/){
		
		if(canMove == true){
			
			if(/*push left button*/){
				
				x++;
				
			}else if(/*push right button*/){
				
				x--;
				
			}else if(/*push up button*/){
				
				y--;
				
			}else if(/*push down button*/){
				
				y++;
				
			}
			
		}
	
	}
	
}
=======
package zombieProject;

public class Player extends Game{

	private double x;
	private double y;
	
	private double health;
	
	
	
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
	
	
	}
	
>>>>>>> 2495ad9cc145bcf6d9687007a7061d43004a4bfb
