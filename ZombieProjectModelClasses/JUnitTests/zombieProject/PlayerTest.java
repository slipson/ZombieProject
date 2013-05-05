package zombieProject;

import org.junit.Test;

import zombieProject.shared.Map;
import zombieProject.shared.Player;
import junit.framework.TestCase;


public class PlayerTest extends TestCase {
	Player p1;
	Player p2;
	Map m;
	
	@Override
	protected void setUp() throws Exception {
		p1 = new Player(0,0);
		p2 = new Player(128, 256);
		m = new Map();
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
	public void testGetPlayerScore(){
		assertEquals(0, p1.getPscore());
	}
	@Test
	public void testIncreasePlayerScore(){
		p1.increasePscore(10);
		assertEquals(10, p1.getPscore());
	}
	@Test
	public void testSetPlayerImageWidth(){
		p1.setPlayerImageWidth(50);
		assertEquals(50, p1.getPlayerImageWidth());
	}
	@Test 
	public void testSetPlayerImageHeight(){
		p1.setPlayerImageHeight(20);
		assertEquals(20, p1.getPlayerImageHeight());
	}
	@Test
	public void testCanMove() throws Exception{
		p1.setX(-10.0);
		p1.setY(14.0);
		assertFalse(p1.canMove(m));
		
		p2.setX(m.getLeft() + 10);
		p2.setY(m.getTop()  + 10);
		assertTrue(p2.canMove(m));
		
		p2.setX(m.getLeft() - 10);
		assertFalse(p2.canMove(m));
		
		
	}
}
