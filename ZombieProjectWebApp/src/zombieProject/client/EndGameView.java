package zombieProject.client;

import zombieProject.shared.Game;
import zombieProject.shared.Score;
import zombieProject.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class EndGameView extends Composite{
	
		private Button startButton;
		//private RichTextArea titleBox;
		private LayoutPanel layoutPanel;
		private TextBox score;
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
			
			Label lblScore = new Label("SCORE:");
			layoutPanel.add(lblScore);
			layoutPanel.setWidgetLeftWidth(lblScore, 107.0, Unit.PX, 104.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(lblScore, 238.0, Unit.PX, 18.0, Unit.PX);
			
			score = new TextBox();
			score.setReadOnly(true);
			
					
					//Session.instance().getUser().getId();
			
			layoutPanel.add(score);
			layoutPanel.setWidgetLeftWidth(score, 107.0, Unit.PX, 173.0, Unit.PX);
			layoutPanel.setWidgetTopHeight(score, 262.0, Unit.PX, 34.0, Unit.PX);
				
		}
		
		public void activate() {
			/*
			RPC.userService.getScore(Session.instance().getUser().getId(), new AsyncCallback<Score>() {
				
				@Override
				public void onSuccess(Score Scor) {
					// TODO Auto-generated method stub
					if(Scor == null){
					}else{
						//TODO set score text to score
						score.setText("" + Scor.getScore());
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO: update UI
					startButton.setText("FAIL!");
				}
			});
			*/
			score.setText("" + Session.instance().getPscore());
			
			// make a Score object recording the player's score
			Score score = new Score();
			score.setUserId(Session.instance().getUser().getId());
			score.setScore(Session.instance().getPscore());
			
			// send the score to the server
			RPC.userService.setScore(score, new AsyncCallback<Void>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO: show error message
				}
				
				@Override
				public void onSuccess(Void result) {
					// TODO: need to update the UI?
					
				}
			});
			// TODO: send score to server via RPC?
		}
		
		protected void handleStartGame() {
			Game model = new Game();
			GameView view = new GameView();
			view.setModel(model);
			ZombieProjectWebApp.instance.setView(view);

		}
	}
