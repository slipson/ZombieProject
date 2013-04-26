package zombieProject.client;

import zombieProject.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	public User logIn(String username, String password);
}
