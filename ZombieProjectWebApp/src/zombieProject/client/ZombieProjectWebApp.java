package zombieProject.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ZombieProjectWebApp implements EntryPoint {
	public static ZombieProjectWebApp instance;
	
	private IsWidget currentView;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()  {
		instance = this;
		
		ZombieView zombieView = new ZombieView();
		
		setView(zombieView);
		
	}

	public void setView(IsWidget view) {
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		
		currentView = view;
		RootLayoutPanel.get().add(view);
		RootLayoutPanel.get().setWidgetLeftRight(view, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetTopBottom(view, 10.0, Unit.PX, 10.0, Unit.PX);
	}
}
