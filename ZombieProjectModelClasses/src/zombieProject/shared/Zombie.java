package zombieProject.shared;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jcoady
 * 
 * The Zombie class creates a zombie object which will act as an enemy to the player object and controlled by the computer.
 * This class has a constructor that initializes a zombie's location as well as its health. There are also getter and setter methods
 * to affect location and health of the zombie. 
 *
 */
public class Zombie{


		private double x; //zombie x-coordinate
		private double y; //zombie y-coordinate
		private int direction = -1;

		private final int Speed = 1;
		private final int attackSpeed = 2;
		
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
			this.direction=(-1);
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
		
		
		public void initDir(){
			this.direction = generator.nextInt(8);
		}
		
		public void chnDir(){
			int a = generator.nextInt(3);
			if(a==0){
				this.direction=this.direction-1;
			}
			if(a==1){
				
			}
			if(a==2){
				this.direction=this.direction+1;
			}
			if(this.direction==-1){
				this.direction=7;
			}
			if(this.direction==8){
				this.direction=0;
			}
		}
		
		public void zombieRoam(){
			if(this.direction==-1){
				this.initDir();
			}
			this.chnDir();
			this.move();
		}
		
		public void move(){		//TODO: needs to check if collide with walls
			if(this.direction==0){
				//up
				this.setY(this.getY()-1);
			}
			else if(this.direction==1){
				//up right

				this.setY(this.getY()-1);
				this.setX(this.getX()+1);


				this.setY(this.getY()-this.Speed);
				this.setX(this.getX()+this.Speed);
				
			}
			else if(this.direction==2){
				//right
				this.setX(this.getX()+1);
			}
			else if(this.direction==3){
				//right down
				this.setX(this.getX()+1);
				this.setY(this.getY()+1);
			}
			else if(this.direction==4){
				//down
				this.setY(this.getY()+1);
			}
			else if(this.direction==5){
				//down left
				this.setY(this.getY()+1);
				this.setX(this.getX()-1);
			}
			else if(this.direction==6){
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
		 * determines if zombie has collided with something
		 * @param m the map coordinates
		 * @return true if zombie CAN move, false if zombie CANNOT move
		 */
		public boolean canMove(Map m){
			//check if zombie is in boundaries first, if zombie is within boundaries then it CAN move around, 
			if(this.x < m.getLeft() || this.x + zombie_width > m.getRight() || this.y < m.getTop() || this.y + zombie_height > m.getBottom()){
				return false;
			}else{
				return true;
			}
		}
		/**
		 * checks all zombies on map if they are colliding with the zombie calling this method
		 * @param zombie arrayList of zombies on the map
		 * @return true = zombie is not colliding, false = zombie is colliding 
		 */
		//NOTE: canMove() method should return true before calling this method.
		//NOTE: this is going to wreak havoc on game speed
		//TODO: make a method to find zombies within a certain radius of zombie calling this method
			//  this will reduce havoc on the game speed
		public boolean checkZombieCollisions(ArrayList<Zombie> zombies){
			boolean collision = true; // bool to determine if there is another collision with a zombie, true = NO COLLISION, false = COLLISION
			
			//check each zombie on the map and check if they are colliding 
			for(int i = 0; i < zombies.size(); i++){
				Zombie zombie = zombies.get(i); // zombie currently being compared to the zombie calling this method
				
				//check to see if the zombie calling this method is colliding with any other zombie on the map
				if(this.getX() > zombie.getX() && this.getX() < zombie.getX() + zombie_width && this.getY() > zombie.getY() && this.getY() < zombie.getY() + zombie_height){
					//ensures that zombie calling this method is not checking collisions on itself
					if(this.getX() != zombie.getX() && this.getY() != zombie.getY()){
						collision = false;
						break;
					}
				}
			}
			return collision;
		}
		
		/**
		 * set the width of the zombie's image to 
		 * @param image_width width of the zombie's image
		 */
		public void setZombieImageWidth(int image_width){
			zombie_width = image_width;
		}
		
		/**
		 * set the height of the zombie's image to 
		 * @param image_height height of the zombie's image
		 */
		public void setZombieImageHeight(int image_height){
			zombie_height = image_height;
		}

}

