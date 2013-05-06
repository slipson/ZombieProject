package zombieProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zombieProject.shared.Spawned;

public class SpawnedTest {

	Spawned tester;
	
	@Before
	public void setUp() throws Exception {
		tester = new Spawned(0.0, 0.0);
	}

	@Test
	public void testGetX() {
		assertEquals(0.0, tester.getX());
	}
	
	@Test
	public void testGetY(){
		assertEquals(0.0, tester.getY());
	}
	
	@Test
	public void testSetX(){
		tester.setX(10.0);
		assertEquals(10.0, tester.getX());
	}
	
	@Test
	public void testSetY(){
		tester.setY(15.0);
		assertEquals(15.0, tester.getY());
	}

}
