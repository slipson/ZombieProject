package zombieProject.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeaponTest {

	private Weapon w1; //weapons test things.....
	private Weapon w2;
	
	@Before
	public void setUp() throws Exception {
		
		w1 = new Weapon(20, 30);
		w2 = new Weapon(40, 100);
		
	}

	//tests getDamage() method
	@Test
	public void getDamageTest() {
		
		assertEquals(20, w1.getDamage());
		assertEquals(40, w2.getDamage());
		
	}
	
	//tests getRange() method
	@Test
	public void getRange(){
		
		assertEquals(30, w1.getRange());
		assertEquals(100, w2.getRange());
		
	}
	

}
