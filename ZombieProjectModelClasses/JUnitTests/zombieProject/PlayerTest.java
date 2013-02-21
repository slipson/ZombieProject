package zombieProject;

import org.junit.Test;

import junit.framework.TestCase;


public class PlayerTest extends TestCase {
	Player p1;
	Player p2;
	
	Zombie z1; // 1st zombie test dummy
	Zombie z2; // 2nd zombie dummy
	Zombie z3; // 3rd zombie dummy
	
	@Override
	protected void setUp() throws Exception {
		p1 = new Player(0,0);
		p2 = new Player(128, 256);
		
		z1 = new Zombie(129, 256);
		z2 = new Zombie(128, 257);
		z3 = new Zombie(150, 300);
	}
	
	@Test
	public void testGetX() throws Exception{
		assertEquals(0.0, p1.getX());
		assertEquals(128.0, p2.getX());
	}
	
	@Test
	public void testSetX() throws Exception{
		p1.setX(90.0);
		assertEquals(90.0, p1.getX());
		p2.setX(346.0);
		assertEquals(346.0, p2.getX());
	}
	
	@Test
	public void testGetY() throws Exception{
		assertEquals(0.0, p1.getY());
		assertEquals(256.0, p2.getY());
	}
	
	@Test
	public void testSetY() throws Exception{
		p1.setY(72.0);
		assertEquals(72.0, p1.getY());
		p2.setY(925.0);
		assertEquals(925.0, p2.getY());
	}
	
	@Test
	public void testGetHealth() throws Exception{
		assertEquals(100.0, p1.getHealth());
		assertEquals(100.0, p2.getHealth());
	}
	
	@Test
	public void testIncreaseHealth() throws Exception{
		p1.increaseHealth(50.0);
		assertEquals(150.0, p1.getHealth());
		p2.increaseHealth(78.0);
		assertEquals(178.0, p2.getHealth());
	}
	
	@Test
	public void testDecreaseHealth() throws Exception{
		p1.decreaseHealth(50.0);
		assertEquals(50.0, p1.getHealth());
		p2.decreaseHealth(50);
		assertEquals(50.0, p2.getHealth());
	}
	
	@Test
	public void testCanMove() throws Exception{
		assertFalse(p1.canMove(z1));
		assertFalse(p1.canMove(z2));
		assertTrue(p1.canMove(z3));
	}
}
