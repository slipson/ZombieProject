package zombieProject.server;

import zombieProject.shared.IDatabase;

public class DB {
	private static IDatabase theInstance = new FakeDatabase(); // change this to SQL database object later
	
	public static IDatabase instance() {
		return theInstance;
	}
}
