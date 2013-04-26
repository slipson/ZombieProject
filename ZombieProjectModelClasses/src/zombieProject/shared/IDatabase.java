package zombieProject.shared;

public interface IDatabase {
	public User logIn(String username, String password);
	boolean logisValid(String username, String password);
	
}
