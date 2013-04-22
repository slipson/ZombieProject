package zombieProject.shared;

import java.awt.Rectangle;

/**
 * @author jcoady
 * 
 * This class creates objects of rectangular shape that act as physical obstacles for the player in the game.
 *
 */
public class Obstacle {

	private Rectangle obstacle; //the obstacle
	
	/**
	 * Obstacle constructor
	 */
	public Obstacle(int x, int y, int size){
		obstacle = new Rectangle(x, y, size, size);
	}
	
	/**
	 * determine whether two obstacles are overlapping
	 * @param x x-coordinate comparator point
	 * @param y y-coordinate of comparator point
	 * @return true = overlap, false = no overlap
	 */
	public boolean doesOverlap(int x, int y){
		return obstacle.contains(x, y);
	}
	
	/**
	 *  getter for x-coordinate of top left point
	 * @return top left x-coordinate
	 */
	public int getX(){
		return (int) obstacle.getX();
	}
	
	/**
	 * getter for y-coordinate of top left point
	 * @return top left y- coordinate
	 */
	public int getY(){
		return (int) obstacle.getY();
	}
	
	/**
	 * returns the width of the obstacle
	 * @return width of obstacle
	 */
	public int getWidth(){
		return (int) obstacle.getWidth();
	}
	
	/**
	 * returns height of obstacle
	 * @return height of obstacle
	 */
	public int getHeight(){
		return (int) obstacle.getHeight();
	}
	
}
