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
			image.setUrl(GWT.getModuleBaseURL() + "GameOverScrn.jpg");//put image address here
			image.setSize("100%", "100%");
			layoutPanel.add(image);
			layoutPanel.setWidgetLeftRight(image, 15.0, Unit.PX, 48.0, Unit.PX);
			layoutPanel.setWidgetTopBottom(image, 0.0, Unit.PX, 0.0, Unit.PX);
			
			startButton = new Button("New button");
			startButton.setStylePrimaryName("EndButton");
			startButton.setText("Play Again?");
			startButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					handleStartGame();
				}
			});
			
			startButton.setStyleName("EndButton");
			layoutPanel.add(startButton);
			startButton.setSize("40", "10");
			layoutPanel.setWidgetLeftWidth(startButton, 40.0, Unit.EM, 11.0, Unit.EM);
			layoutPanel.setWidgetBottomHeight(startButton, 23.5, Unit.EM, 4.5, Unit.EM);
				
		}
		
		
		protected void handleStartGame() {
			Game model = new Game();
			GameView view = new GameView();
			view.setModel(model);
			ZombieProjectWebApp.instance.setView(view);
		}
	}


