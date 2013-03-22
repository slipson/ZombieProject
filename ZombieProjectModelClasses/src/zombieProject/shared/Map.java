package zombieProject.shared;

public class Map {
	
	double lftBndry = 0;
	double ritBndry = 800;//later find actual width
	double topBndry = 0;
	double btmBndry = 600;//later find actual height
	
	
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
}
