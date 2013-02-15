package zombieProject;

public class Player extends Game{

	private double x;
	private double y;
	
	private double health;
	
	
	
	public Player(double x, double y){
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
	
	
	}
	
