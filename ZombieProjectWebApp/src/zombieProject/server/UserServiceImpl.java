package zombieProject.server;

import zombieProject.client.UserService;
import zombieProject.shared.Score;
import zombieProject.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1324351697056497046L;

	@Override
	public User logIn(String username, String password) {
		return DB.instance().logIn(username, password);
	}
	
	public Score getScore(int ID){
		return DB.instance().getScore(ID);
	}

	@Override
	public void setScore(Score score) {
		DB.instance().setScore(score);
		
	}
	
//	public boolean logisValid(String username, String password){
//		return DB.instance().logisValid(username, password);
//	}


}
