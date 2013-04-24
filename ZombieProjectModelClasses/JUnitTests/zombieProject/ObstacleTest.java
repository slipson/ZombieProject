package zombieProject;

import org.junit.Test;

import zombieProject.shared.Obstacle;
import junit.framework.TestCase;

public class ObstacleTest extends TestCase {

	Obstacle obstacle1;
	Obstacle obstacle2;
	
	
	@Override
	public void setUp(){
		obstacle1 = new Obstacle(0, 0, 5);
		obstacle2 = new Obstacle(10, 10, 50, 20);
	}
	
	@Test
	public void doesOverlapTest() throws Exception{
		assertFalse(obstacle1.doesOverlap(obstacle2.getX(), obstacle2.getY()));
	}
	
	
}
