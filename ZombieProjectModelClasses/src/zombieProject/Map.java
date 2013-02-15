package zombieProject;

import java.awt.Frame;

public class Map {

	//hard coded boundaries 
	
	double lftBndry = 0;
	double  ritBndry = 100;//later find actual width
	double topBndry = 0;
	double btmBndry = 100;//later find actual height
	
	
	public double getLeft()
	{
		return this.lftBndry;
	}

	public double getRight()
	{
		return this.ritBndry;
	}
	public double getTop()
	{
		return this.topBndry;
	}
	public double getBottom()
	{
		return this.btmBndry;
	}
	
	/**
	 * Is given x/y (location) a valid location for given Player?
	 * 
	 * @param player the Player
	 * @param x      x coord
	 * @param y      y coord
	 * @return true if this x/y is a valid location, false if not (overlap with walls)
	 */
	public boolean isLegalPosition(Player player, double x, double y) {
		if( x > this.getLeft() | x < this.getRight()){
			if( y > this.getTop() | y < this.getBottom()){
				return true;
			}
			else{ return false;}
		}
		else{ return false;}
		
	}
}

