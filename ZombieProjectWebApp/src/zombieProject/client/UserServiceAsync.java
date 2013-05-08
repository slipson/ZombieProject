package zombieProject.client;

import zombieProject.shared.Score;
import zombieProject.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void logIn(String username, String password, AsyncCallback<User> callback);
	void getScore(int ID, AsyncCallback<Score> callback);
	void setScore(Score score, AsyncCallback<Void> asyncCallback);
}
