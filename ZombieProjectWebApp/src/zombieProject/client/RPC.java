package zombieProject.client;

import com.google.gwt.core.shared.GWT;

public class RPC {
	public static final UserServiceAsync userService =
			GWT.create(UserService.class);
}
