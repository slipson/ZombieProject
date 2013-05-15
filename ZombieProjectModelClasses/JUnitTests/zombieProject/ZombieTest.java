package zombieProject;

import junit.framework.TestCase;

import org.junit.Test;

import zombieProject.shared.Player;
import zombieProject.shared.Zombie;


	public class ZombieTest extends TestCase {
		Zombie z1;
		Zombie z2;
		Zombie z3;
		Player p1;
		
		@Override
		protected void setUp() throws Exception {
			z1 = new Zombie(0,0);
			z2 = new Zombie(128, 256);
			z3 = new Zombie(10.0, 10.0);
			p1 = new Player(10, 10);
		}
		@Test
		public void testGetX() throws Exception{
			assertEquals(0.0, z1.getX());
			assertEquals(128.0, z2.getX());
		}
		@Test
		public void testSetX() throws Exception{
			z1.setX(90.0);
			assertEquals(90.0, z1.getX());
			z2.setX(346.0);
			assertEquals(346.0, z2.getX());
		}
		@Test
		public void testGetY() throws Exception{
			assertEquals(0.0, z1.getY());
			assertEquals(256.0, z2.getY());
		}
		@Test
		public void testSetY() throws Exception{
			z1.setY(72.0);
			assertEquals(72.0, z1.getY());
			z2.setY(925.0);
			assertEquals(925.0, z2.getY());
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
		@Test
		public void testMoveTowardsPlayerUp() throws Exception{
			p1.setY(10.0);
			p1.setX(10.0);
			z1.setX(5.0);
			z1.setY(5.0);
			assertEquals(5.0, z1.getX());
			assertEquals(5.0, z1.getY());
			z1.moveTowardsPlayer(p1);
			assertEquals(6.0, z1.getY());
			assertEquals(6.0, z1.getX());
		}
		@Test
		public void testMoveTowardsPlayerDown() throws Exception{
			p1.setY(10.0);
			p1.setX(10.0);
			z1.setX(15.0);
			z1.setY(15.0);
			assertEquals(15.0, z1.getX());
			assertEquals(15.0, z1.getY());
			z1.moveTowardsPlayer(p1);
			assertEquals(14.0, z1.getX());
			assertEquals(14.0, z1.getY());
			
			z1.setX(15.0);
			z1.moveTowardsPlayer(p1);
			assertEquals(14.0, z1.getX());
			
			
		}
		@Test
		public void testzombieRoam() throws Exception{
			z1.setX(15.0);
			z1.setY(15.0);
			z1.zombieRoam();
			if(z1.getX() != 15.0 || z1.getY() != 15.0){
				assertEquals(true, true);
			}
			else{
				assertEquals(false, true);
			}
		}
		@Test
		public void testZombieMove() throws Exception{
			p1.setY(10.0);
			p1.setX(10.0);
			z1.setX(15.0);
			z1.setY(15.0);
			z2.setX(200.0);
			z2.setY(200.0);
			z1.zMove(p1);
			z2.zMove(p1);
			assertEquals(14.0, z1.getX());
			assertEquals(14.0, z1.getY());
			if(z2.getX() != 15.0 || z2.getY() != 15.0){
				assertEquals(true, true);
			}
			else{
				assertEquals(false, true);
			}
			
		}

		
}

