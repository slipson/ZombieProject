package zombieProject.shared;

public class Player {

	private double x; //player's x coordinate
	private double y; //player's y coordinate
	private int player_width = 0; //the width of player image
	private int player_height = 0; //the height of player image
	private double health; //player's health
	private int Ammo = 6;
	private int MaxAmmo = 6;
	private double playrScore = 0; //player's score



	
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
	
	public double getPscore(){
		return playrScore;
	}
	
	public void increasePscore(double d){// increase playrScore by playScore
		this.playrScore += d;
	}
	
	/**
	 * set image_width variable to width of the image representing player
	 * @param width the width of the player image
	 */
	public void setPlayerImageWidth(int width){
		this.player_width = width;
	}
	/**
	 * getter for the player's image width
	 * @return the width of the player's image
	 */
	public int getPlayerImageWidth(){
		return this.player_width;
	}
	/**
	 * getter for the player's image height
	 * @return the height of the player's image
	 */
	public int getPlayerImageHeight(){
		return this.player_height;
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

//	public boolean canMove(Map m/*, Obstacle obs*/){
//		//check to see if player is within playable boundaries, if player is trying to move outside boundaries, return false
//		if(this.x < m.getLeft() || this.x + player_width >= m.getRight() || this.y <= m.getTop() || this.y + player_height >= m.getBottom()){
//			return false;
//		}else{
//			return true;
//			//NOTE: might need to change taking obstacles into account
//			if(this.x > obs.getX() && this.x < obs.getX() + obs.getWidth() && this.y > obs.getY() && this.y < obs.getY() + obs.getHeight()){
//				return false;
//			}else{
//				return true;
//			}*/
//		}
//	}

	
	public int getAmmo(){
		return this.Ammo;
	}
	
	
	public void decreaseAmmo(){
		this.Ammo-=1;
	}
	
	public void refillAmmo() {
		this.Ammo=MaxAmmo;
		
	}
	
}
