package zombieProject;

import org.junit.Test;

import junit.framework.TestCase;


public class PlayerTest extends TestCase {
	Player p1;
	Player p2;
	
	@Override
	protected void setUp() throws Exception  {
		p1 = new Player(0,0);
		p2 = new Player(128, 256);
	}
	
	@Test
	public void testGetX() throws Exception{
		assertEquals(0, p1.getX());
		assertEquals(128, p2.getX());
	}
	
	@Test
	public void testSetX() throws Exception{
		p1.setX(90);
		assertEquals(90, p1.getX());
		p2.setX(346);
		assertEquals(346, p2.getX());
	}
	
	@Test
	public void testGetY() throws Exception{
		assertEquals(0, p1.getY());
		assertEquals(256, p2.getY());
	}
	
	@Test
	public void testSetY() throws Exception{
		p1.setY(72);
		assertEquals(90, p1.getY());
		p2.setY(925);
		assertEquals(346, p2.getY());
	}
	
	@Test
	public void testGetHealth() throws Exception{
		assertEquals(100, p1.getHealth());
		assertEquals(100, p2.getHealth());
	}
	
	@Test
	public void testIncreaseHealth() throws Exception{
		p1.increaseHealth(50);
		assertEquals(150, p1.getHealth());
		p2.increaseHealth(78);
		assertEquals(178, p2.getHealth());
	}
	
	@Test
	public void testDecreaseHealth() throws Exception{
		p1.decreaseHealth(50);
		assertEquals(50, p1.getHealth());
		p2.decreaseHealth(50);
		assertEquals(50, p2.getHealth());
	}
}
