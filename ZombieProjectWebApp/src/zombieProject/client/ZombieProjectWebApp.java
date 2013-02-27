package zombieProject.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ZombieProjectWebApp implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()  {
		
		
		ZombieView zombieView = new ZombieView();
		LayoutPanel panel = new LayoutPanel();
		
		panel.add(zombieView);
		
		
	}
}
