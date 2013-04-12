package zombieProject.shared;

public class Player {

	private double x; //player's x coordinate
	private double y; //player's y coordinate
	private int player_width = 0; //the width of player image
	private int player_height = 0; //the height of player image
	private double health; //player's health
	
	/**
	 * Player constructor
	 * @param x initial x coordinate
	 * @param y initial y coordinate
	 */
	public Player(double x, double y){
		
		//NOTE: may need to add parameters for width and height of image representing player.
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
	 * set image_width variable to width of the image representing player
	 * @param width the width of the player image
	 */
	public void setPlayerImageWidth(int width){
		this.player_width = width;
	}
	
	/**
	 * set image_height variable to height of the image representing player
	 * @param height the height of the player image
	 */
	public void setPlayerImageHeight(int height){
		this.player_height = height;
	}
	
	/**
	 * boolean to determine whether player can move to new coordinates on map
	 * @param m the map
	 * @return false = player CANNOT move, true = player CAN move
	 */
	public boolean canMove(Map m){
		//NOTE: Change 1's to 2's
		
		//check to see if player is within playable boundaries, if player is trying to move outside boundaries, return false
		if(this.x < m.getLeft() || this.x + player_width >= m.getRight() || this.y <= m.getTop() || this.y + player_height >= m.getBottom()){
			return false;
		}else{
			//if player's next move is a zombie location, player cannot move there.
			/*if((x + this.player_width) + 1 == z.getX() || x - 1 == z.getX() || (y + this.player_height) + 1 == z.getY() || y - 1 == z.getY()){
				return false;
			}else{
				return true;
			}*/
			
			return true;
			
		}
		
	}
	
	public void checkZombieCollision(){
		
	}
	
	
	
}
