package zombieProject.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.dom.client.Style.Unit;

public class GameView extends Composite {
	public GameView() {
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
		InlineLabel nlnlblThisIsThe = new InlineLabel("This is the game!");
		layoutPanel.add(nlnlblThisIsThe);
		layoutPanel.setWidgetLeftWidth(nlnlblThisIsThe, 109.0, Unit.PX, 202.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(nlnlblThisIsThe, 25.0, Unit.PX, 18.0, Unit.PX);
	}
}
