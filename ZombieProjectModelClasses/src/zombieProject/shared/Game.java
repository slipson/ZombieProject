package zombieProject.shared;

/**
 * @author jcoady
 * 
 * The Game class is essentially the engine for this game. This class updates initializes, and updates the game state
 * which would be shown by the UI of the game. Methods in this class include getter and setter methods for the player object.
 *
 */
public class Game {
	
	private Map m; //game map
	private Player p; //player
	
	private int key = 0; //key to determine user action
	
	/**
	 * game constructor
	 */
	public Game(){
		
		m = new Map();
		p = new Player(0, 0);
		
	}
	
	/**
	 * updates the game state
	 * 
	 * @param game the game object
	 */
	public void updateGame(Game game){
		
		if(key == 0){
			
			//do something
			
		}
		
		if(key == 1){
			
			//do a different thing
			
		}
		
		
		//We are going to need to decide on if we are using a 
		//loop to generate multiple zombies and generate them
		//either randomly or according to a difficulty.
		//Difficulty could depend on the room that the user
		//has just entered. 
		/*for(int i = 0; i < numZombies; i++){//loop to initialize all zombies
			zombiArr[i].setX((i * 10) + 10);
			zombiArr[i].setY(10);
		}
		boolean collision;// use this value later to regulate movement of player
		
		for(Zombie z : zombiArr){
			if((p.getX() + 1 < z.getX() - 1) | (p.getX() - 1 > z.getX() + 1)){
				if((p.getY() + 1 < z.getY() - 1) | (p.getY() - 1 > z.getY() + 1)){
					collision = false;
				}
				else{
					collision = true;
				}
			}
			else{
				collision = true;
			}
		}*/
		
		
	}
	
	
	/*public static void main(String[] args){
		
		Map m = new Map();
		//spawns player in center of map
		Player p = new Player(m.getRight()/2, m.getBottom()/2);
		
		//We are going to need to decide on if we are using a 
		//loop to generate multiple zombies and generate them
		//either randomly or according to a difficulty.
		//Difficulty could depend on the room that the user
		//has just entered. 
		
		int numZombies = 2;//temporary value
		Zombie[] zombiArr = new Zombie[numZombies];
		
		for(int i = 0; i < numZombies; i++){//loop to initialize all zombies
			zombiArr[i].setX((i * 10) + 10);
			zombiArr[i].setY(10);
		}
		boolean collision;// use this value later to regulate movement of player
		
		for(Zombie z : zombiArr){
			if((p.getX() + 1 < z.getX() - 1) | (p.getX() - 1 > z.getX() + 1)){
				if((p.getY() + 1 < z.getY() - 1) | (p.getY() - 1 > z.getY() + 1)){
					collision = false;
				}
				else{
					collision = true;
				}
			}
			else{
				collision = true;
			}
		}
		
		
	}*/
	
	/**
	 * returns player's x-coordinate
	 * 
	 * @param p the player
	 * @return player's x-coordinate
	 */
	public double getPlayerX(){
		return p.getX();
	}
	
	/**
	 * returns player's y-coordinate
	 * 
	 * @param p the player
	 * @return player's y-coordinate
	 */
	public double getPlayerY(){
		return p.getY();
	}
	public double getZombieX(Zombie z){
		return z.getX();
	}
	public double getZombieY(Zombie z){
		return z.getY();
	}
	
	/**
	 * sets currently pressed key to update player state
	 * 
	 * @param key the key the user is pressing
	 */
	public void setKey(int key){
		 this.key = key;
	}
	 
	
}
