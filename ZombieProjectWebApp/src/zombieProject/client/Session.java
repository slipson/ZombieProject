package zombieProject.client;

import zombieProject.shared.User;

public class Session {
	
	private static final Session theInstance = new Session();
	
	public static Session instance() {
		return theInstance;
	}
	
	private Session() {
		
	}
	
	private User user;
	private int pscore;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void clear() {
		user = null;
		pscore = 0;
		// etc.
	}

	public void setPlayerScore(int pscore) {
		this.pscore = pscore;
	}
	
	public int getPscore() {
		return pscore;
	}
	
	public int getID(){
		return user.getId();
	}
	
}
