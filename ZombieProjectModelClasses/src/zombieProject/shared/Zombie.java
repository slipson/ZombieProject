package zombieProject.shared;

import java.util.Random;


/**
 * @author jcoady
 * 
 * The Zombie class creates a zombie object which will act as an enemy to the player object and controlled by the computer.
 * This class has a constructor that initializes a zombie's location as well as its health. There are also getter and setter methods
 * to affect location and health of the zombie. 
 *
 */

public class Zombie extends Game {

		private double x; //zombie x-coordinate
		private double y; //zombie y-coordinate
		
		private int zombie_width = 0; // width of image representing zombie
		private int zombie_height = 0; // height of image representing zombie
		
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


		
		public void zMove(Player p){
			double temp;
			// distance formula sqrt((zx-px)^2+(zy-py)^2))
			temp = Math.sqrt((this.getX()-p.getX())*(this.getX()-p.getX())+(this.getY()-p.getY())*(this.getY()-p.getY()));
			if(temp<100.0){
				moveTowardsPlayer(p);
			}
			else{
				zombieRoam();
			}
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
		
		/**
		 * 
		 * @param z
		 * @return true if zombie CAN move, false if zombie CANNOT move
		 */
		public boolean canMove(Player p){
			
			//NOTE: Change 1's to 2's
			
			//check if zombie is in boundaries first, then check if zombie collides with player
			
			//if player's next move is a zombie location, player cannot move there.
			if((x + this.zombie_width) + 1 == p.getX() || x - 1 == p.getX() || (y + this.zombie_height) + 1 == p.getY() || y - 1 == p.getY()){
				return false;
			}else{
				return true;
			}
			
		}
		
		

}
