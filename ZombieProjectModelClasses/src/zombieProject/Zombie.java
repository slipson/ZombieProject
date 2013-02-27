package zombieProject;

public class Zombie {

		private double x; //zombie x-coordinate
		private double y; //zombie y-coordinate
		
		private double health; //zombie health
		
		public Zombie(double x, double y){
			this.x = x;
			this.y = y;
			
			health = 50;
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
		
		public double getHealth() {
			return health;
		}
		/** 
		 * A Zombie's health will decrease IF the player's
		 * bullet's coordinates are the same as the Zombie's.
		 * In other words, Zombie got shot.
		 * 
		 * @param val
		 */
		public void decreaseHealth(double val){
			this.health -= val;
		}
		
		public void zombieMove(Player p){
			if(p.getX()>this.getX()){		// movement in the x direction towards the player
				this.setX(this.getX()+1);
			}
			else if(p.getX()<this.getX()){
				this.setX(this.getX()-1);
			}
			
			if(p.getY()>this.getY()){		// movement in the y direction towards the player
				this.setY(this.getY()+1);
			}
			else if(p.getY()<this.getY()){
				this.setY(this.getY()-1);
			}
		}

}
