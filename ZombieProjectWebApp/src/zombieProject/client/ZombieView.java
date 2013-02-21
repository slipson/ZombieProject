package zombieProject.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Date;
import com.google.gwt.user.client.ui.Image;

public class ZombieView extends Composite {
	private Button startButton;
	private RichTextArea titleBox;
	private LayoutPanel layoutPanel;
	public ZombieView() {
		
		layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setHeight("592px");
		
		startButton = new Button("New button");
		startButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//code to start the game
			}
		});
		startButton.setText("Start the game already!");
		layoutPanel.add(startButton);
		layoutPanel.setWidgetLeftWidth(startButton, 86.0, Unit.PX, 184.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(startButton, 240.0, Unit.PX, 30.0, Unit.PX);
		
		titleBox = new RichTextArea();
		titleBox.setStyleName("h1");
		titleBox.setText("PLAY IF YOU DARE");
		layoutPanel.add(titleBox);
		layoutPanel.setWidgetLeftWidth(titleBox, 34.0, Unit.PX, 304.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(titleBox, 36.0, Unit.PX, 154.0, Unit.PX);
		
		DateBox dateBox = new DateBox();
		dateBox.setValue(new Date(1361470300976L));
		layoutPanel.add(dateBox);
		layoutPanel.setWidgetLeftWidth(dateBox, 17.0, Unit.PX, 157.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(dateBox, 540.0, Unit.PX, 32.0, Unit.PX);
		
	}
}
