package zombieProject.shared;

import java.util.Random;

public class Zombie  {

		private double x; //zombie x-coordinate
		private double y; //zombie y-coordinate
		
		Random generator = new Random();
		
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
		
		
		
		public void moveTowardsPlayer(Player p){
			if(p.getX()>this.getX()){
				this.setX(this.getX()+1);
			}
			else if(p.getX()<this.getX()){
				this.setX(this.getX()-1);
			}
			if(p.getY()>this.getY()){
				this.setY(this.getY()+1);
			}
			else if(p.getY()<this.getY()){
				this.setY(this.getY()-1);
			}
		}
		
		
		public void zombieRoam(){		//TODO: needs to check if collide with walls
			int a = generator.nextInt(8);
			if(a==0){
				//up
				this.setY(this.getY()-1);
			}
			else if(a==1){
				//up right
				this.setY(this.getY()-1);
				this.setX(this.getY()+1);
			}
			else if(a==2){
				//right
				this.setX(this.getX()+1);
			}
			else if(a==3){
				//right down
				this.setX(this.getX()+1);
				this.setY(this.getY()+1);
			}
			else if(a==4){
				//down
				this.setY(this.getY()+1);
			}
			else if(a==5){
				//down left
				this.setY(this.getY()+1);
				this.setX(this.getX()-1);
			}
			else if(a==6){
				//left
				this.setX(this.getX()-1);
			}
			else{
				//left up
				this.setX(this.getX()-1);
				this.setY(this.getY()-1);
			}
			
		}
		
		
}
