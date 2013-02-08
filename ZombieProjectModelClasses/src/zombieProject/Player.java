package zombieProject;

import java.util.Scanner;

public class Player{

	private double x;
	private double y;
	
	private double health;
	
	String input;
	Scanner keypress = new Scanner(input);
	
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
	
	
	//check if collision possible
	//if not allow movement
	//This is for all y'all
	
	
	
}
