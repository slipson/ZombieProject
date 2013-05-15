package zombieProject;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import zombieProject.shared.Game;

public class GameTester {

	Game game;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	
	@Test
	public void testGetPlayer(){
		assertEquals(game.getPlayer(), game.getPlayer());
	}
	@Test
	public void testGetZombie(){
		assertEquals(game.getZombie(0), game.getZombie(0));
	}
	@Test
	public void testNewZombie(){
		game.newZombie();
		assertEquals(game.getZombie(0), game.getZombie(0));
		int count = game.listSize();
		game.removeZ(0);
		count -= 1;
		assertEquals(count, game.listSize());
	}
	@Test
	public void testGetSpawned(){
		game.newSpawn();
		assertEquals(game.getSpawned(0), game.getSpawned(0));
		game.newSpawn();
		int count = game.spawnSize();
		game.removeS(0);
		count -= 1;
		assertEquals(count, game.spawnSize());
	}
	@Test
	public void testZombieListSize(){
		int count = game.listSize();
		assertEquals(count, game.listSize());
	}
	@Test
	public void testSpawnSize(){
		int count = game.spawnSize();
		assertEquals(count, game.spawnSize());
	}
	
}
