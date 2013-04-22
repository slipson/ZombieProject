package zombieProject.server;

import java.util.ArrayList;

import zombieProject.shared.IDatabase;
import zombieProject.shared.Score;
import zombieProject.shared.User;

public class FakeDatabase implements IDatabase {
	private ArrayList<User> userList;
	private ArrayList<Score> scoreList;
	
	public FakeDatabase() {
		userList = new ArrayList<User>();
		scoreList = new ArrayList<Score>();
		
		User user1 = new User();
		user1.setUsername("alice");
		user1.setPassword("abc");
		
		User user2 = new User();
		user2.setUsername("bob");
		user2.setPassword("def");
		
		userList.add(user1);
		user1.setId(userList.size());
		
		userList.add(user2);
		user2.setId(userList.size());
		
		scoreList = new ArrayList<Score>();
		
		Score score1 = new Score();
		score1.setUserId(user1.getId());
		score1.setScore(12345);
		
		Score score2 = new Score();
		score2.setUserId(user2.getId());
		score2.setScore(23456);
		
		scoreList.add(score1);
		scoreList.add(score2);
	}
	
	@Override
	public User logIn(String username, String password) {
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
