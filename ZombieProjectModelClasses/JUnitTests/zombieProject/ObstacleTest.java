package zombieProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zombieProject.shared.Obstacle;

public class ObstacleTest {
	
	Obstacle obstacle, obstacle2;

	@Before
	public void setUp() throws Exception {
		obstacle = new Obstacle(10, 10, 50, 20);
		obstacle2 = new Obstacle(10, 10, 10);
	}

	@Test
	public void getXTest() {
		assertEquals(10, obstacle.getX());
	}
	
	@Test
	public void getYTest(){
		assertEquals(10, obstacle.getY());
	}
	
	@Test
	public void getWidthTest(){
		assertEquals(50, obstacle.getWidth());
	}
	
	@Test
	public void getHeightTest(){
		assertEquals(20, obstacle.getHeight());
	}
	
	@Test
	public void doesOverLapTest(){
		assertFalse(obstacle.doesOverlap(30, 60));
		assertTrue(obstacle.doesOverlap(15, 15));
	}

}
