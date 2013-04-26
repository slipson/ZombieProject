package zombieProject.server;

import zombieProject.client.UserService;
import zombieProject.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

	@Override
	public User logIn(String username, String password) {
		return DB.instance().logIn(username, password);
	}

}
