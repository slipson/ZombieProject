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
		user1.setUsername("aschin");
		user1.setPassword("zombie");
		
		User user2 = new User();
		user2.setUsername("slipson");
		user2.setPassword("zombie");
		
		User user3 = new User();
		user3.setUsername("sbonner");
		user3.setPassword("zombie");
		
		User user4 = new User();
		user4.setUsername("josh");
		user4.setPassword("zombie");
		
		userList.add(user1);
		user1.setId(userList.size());
		
		userList.add(user2);
		user2.setId(userList.size());
		
		userList.add(user3);
		user3.setId(userList.size());
		
		userList.add(user4);
		user4.setId(userList.size());
		
		scoreList = new ArrayList<Score>();
		
		Score score1 = new Score();
		score1.setUserId(user1.getId());
		score1.setScore(12345);
		
		Score score2 = new Score();
		score2.setUserId(user2.getId());
		score2.setScore(23456);
		
		Score score3 = new Score();
		score3.setUserId(user3.getId());
		score3.setScore(33333);
		
		Score score4 = new Score();
		score4.setUserId(user4.getId());
		score4.setScore(44454);
		
		scoreList.add(score1);
		scoreList.add(score2);
		scoreList.add(score3);
		scoreList.add(score4);
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
//	@Override
//	public boolean logisValid(String username, String password){
//		boolean bool = false;
//		
//		for(User user : userList){
//			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
//				bool = true;
//				break;
//			}else{
//				bool = false;
//			}
//		}
//		return bool;
//		
//	}
}
