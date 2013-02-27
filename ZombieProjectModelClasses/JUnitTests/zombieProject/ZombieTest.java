package zombieProject;

import junit.framework.TestCase;

import org.junit.Test;


	public class ZombieTest extends TestCase {
		Zombie z1;
		Zombie z2;
		
		@Override
		protected void setUp() throws Exception {
			z1 = new Zombie(0,0);
			z2 = new Zombie(128, 256);
		}
		
		@Test
		public void testGetX() throws Exception{
			assertEquals(0.0, z1.getX());
			assertEquals(128.0, z2.getX());
		}
		
		@Test
		public void testSetX() throws Exception{
			z1.setX(90);
			assertEquals(90, z1.getX());
			z2.setX(346);
			assertEquals(346, z2.getX());
		}
		
		@Test
		public void testGetY() throws Exception{
			assertEquals(0.0, z1.getY());
			assertEquals(256.0, z2.getY());
		}
		
		@Test
		public void testSetY() throws Exception{
			z1.setY(72);
			assertEquals(72, z1.getY());
			z2.setY(925);
			assertEquals(925, z2.getY());
		}
		
		@Test
		public void testGetHealth() throws Exception{
			assertEquals(50.0, z1.getHealth());
			assertEquals(50.0, z2.getHealth());
		}
		
		
		@Test
		public void testDecreaseHealth() throws Exception{
			z1.decreaseHealth(50.0);
			assertEquals(0.0, z1.getHealth());
			z2.decreaseHealth(25);
			assertEquals(25.0, z2.getHealth());
		}
}

