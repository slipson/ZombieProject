package zombieProject.shared;

public class Player {



	public double x; //player's x coordinate
	public double y; //player's y coordinate
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
		this.health = 100;
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
		if(this.health>100){
			this.health=100;
		}
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
	 * @param m the map coordinates
	 * @return false = player CANNOT move, true = player CAN move
	 */
	public boolean canMove(Map m){
		//check to see if player is within playable boundaries, if player is trying to move outside boundaries, return false
		if(this.x < m.getLeft() || this.x + player_width >= m.getRight() || this.y <= m.getTop() || this.y + player_height >= m.getBottom()){
			return false;
		}else{
			return true;
		}
	}
	
}
