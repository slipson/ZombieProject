package zombieProject.client;

import zombieProject.shared.Game;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Image;

public class EndGameView extends Composite{
	

		private Button startButton;
		//private RichTextArea titleBox;
		private LayoutPanel layoutPanel;
		public EndGameView() {
			
			layoutPanel = new LayoutPanel();
			initWidget(layoutPanel);
			layoutPanel.setSize("1275px", "601px");
			
			Image image = new Image();
			image.setUrl(GWT.getModuleBaseURL() + "");//put image address here
			image.setSize("100%", "100%");
			layoutPanel.add(image);
			layoutPanel.setWidgetLeftRight(image, 0.0, Unit.PX, 61.0, Unit.PX);
			layoutPanel.setWidgetTopBottom(image, 0.0, Unit.PX, 0.0, Unit.PX);
			
			startButton = new Button("New button");
			startButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					handleStartGame();
				}
			});
			startButton.setText("Play Again");
			startButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					if(startButton.isEnabled()){
						startButton.setText("Good Luck!");
					}
				}
			});
			layoutPanel.add(startButton);
			layoutPanel.setWidgetLeftWidth(startButton, 515.0, Unit.PX, 180.0, Unit.PX);
			layoutPanel.setWidgetBottomHeight(startButton, 318.0, Unit.PX, 30.0, Unit.PX);
				
		}
		
		protected void handleStartGame() {
			Game model = new Game();
			GameView view = new GameView();
			view.setModel(model);
			ZombieProjectWebApp.instance.setView(view);
		}
	}


