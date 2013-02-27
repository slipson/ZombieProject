package zombieProject;

public class Zombie {

		private int x; //zombie x-coordinate
		private int y; //zombie y-coordinate
		
		private double health; //zombie health
		
		/**
		 * Zombie constructor
		 * 
		 * @param x initial x-coordinate
		 * @param y initial y-coordinate
		 */
		public Zombie(int x, int y){
			this.x = x;
			this.y = y;
			
			health = 50;
		}
		
		/**
		 * returns the zombie's x-coordinate
		 */
		public double getX(){
			return x;
		}
		
		/**
		 * set the zombie's x-coordinate
		 * 
		 * @param x new x-coordinate
		 */
		public void setX(int x){
			this.x = x;
		}
		
		/**
		 * returns the zombie's y-coordinate
		 */
		public double getY(){
			return y;
		}
		
		/**
		 * set the zombie's y-coordinate
		 * 
		 * @param y new y-coordinate
		 */
		public void setY(int y){
			this.y = y;
		}
		
		/**
		 * return zombies health
		 */
		public double getHealth() {
			return health;
		}
		/** 
		 * A Zombie's health will decrease IF the player's
		 * bullet's coordinates are the same as the Zombie's.
		 * In other words, Zombie got shot.
		 * 
		 * @param val the value to remove from health
		 */
		public void decreaseHealth(double val){
			this.health -= val;
		}
}
