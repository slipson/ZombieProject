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


import java.util.Random;






public class Zombie{



		public double x; //zombie x-coordinate
		public double y; //zombie y-coordinate
		public int direction = -1;
		
		
		private double health; //zombie health
		
		Random generator = new Random();
		
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


		
//		public void setDirection(int d){
//			this.direction = d;
//		}



		
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
				this.setX(this.getY()+1);
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
}
		
		


		
	
