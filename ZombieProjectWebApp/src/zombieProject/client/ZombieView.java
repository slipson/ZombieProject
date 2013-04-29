package zombieProject.client;

import zombieProject.server.DB;
import zombieProject.server.FakeDatabase;
import zombieProject.shared.Game;
import zombieProject.shared.IDatabase;
import zombieProject.shared.User;
import zombieProject.client.GameView;
import zombieProject.client.RPC;
import zombieProject.client.ZombieProjectWebApp;
import zombieProject.client.ZombieView;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Image;

	public class ZombieView extends Composite{
		

			private Button startButton;
			//private TextBox UsernameBox;
			//private RichTextArea PasswordBox;
			//private RichTextArea titleBox;
			private LayoutPanel layoutPanel;
			public ZombieView() {
				
				layoutPanel = new LayoutPanel();
				initWidget(layoutPanel);
				layoutPanel.setSize("1275px", "601px");
				
				Image image = new Image();
				image.setUrl(GWT.getModuleBaseURL() + "ZombieProjectMainPage2.png");// initial screen
				image.setSize("100%", "100%");
				layoutPanel.add(image);
				layoutPanel.setWidgetLeftRight(image, 15.0, Unit.PX, 48.0, Unit.PX);
				layoutPanel.setWidgetTopBottom(image, 0.0, Unit.PX, 0.0, Unit.PX);
				
				final TextBox UsernameBox = new TextBox();
				layoutPanel.add(UsernameBox);
				layoutPanel.setWidgetLeftWidth(UsernameBox, 559.0, Unit.PX, 200.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(UsernameBox, 221.0, Unit.PX, 30.0, Unit.PX);
				UsernameBox.setSize("200", "30");
				
				final TextBox PasswordBox = new TextBox();
				layoutPanel.add(PasswordBox);
				layoutPanel.setWidgetLeftWidth(PasswordBox, 559.0, Unit.PX, 200.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(PasswordBox, 280.0, Unit.PX, 30.0, Unit.PX);
				PasswordBox.setSize("200", "30");
				
				startButton = new Button("New button");
				startButton.setText("ENTER");
				startButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						/*
						if(DB.instance().logisValid(UsernameBox.getText(), PasswordBox.getText()) == true){
							handleStartGame();
						}else{
							startButton.setText("Retry!");
						}
						*/
						RPC.userService.logIn(UsernameBox.getText(), PasswordBox.getText(), new AsyncCallback<User>() {
							
							@Override
							public void onSuccess(User result) {
								if (result == null) {
									// no such username/password
									// TODO: update UI
									startButton.setText("Retry!");
								} else {
									handleStartGame();
								}
								
							}
							
							@Override
							public void onFailure(Throwable caught) {
								// TODO: update UI
								startButton.setText("FAIL!");
							}
						});
					}
				});
				
				startButton.setStyleName("sendButton");
				layoutPanel.add(startButton);
				startButton.setSize("40", "10");
				layoutPanel.setWidgetLeftWidth(startButton, 40.9, Unit.EM, 11.0, Unit.EM);
				layoutPanel.setWidgetBottomHeight(startButton, 0.0, Unit.EM, 4.5, Unit.EM);
				
				Label lblUsername = new Label();
				lblUsername.setStyleName("dialogVPanel");
				lblUsername.setText("Username:");
				layoutPanel.add(lblUsername);
				layoutPanel.setWidgetLeftWidth(lblUsername, 453.0, Unit.PX, 100.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(lblUsername, 217.0, Unit.PX, 34.0, Unit.PX);
				
				Label lblPassword = new Label();
				lblPassword.setText("Password:");
				lblPassword.setStyleName("dialogVPanel");
				layoutPanel.add(lblPassword);
				layoutPanel.setWidgetLeftWidth(lblPassword, 453.0, Unit.PX, 100.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(lblPassword, 280.0, Unit.PX, 34.0, Unit.PX);
					
			}
	
	protected void handleStartGame() {
		Game model = new Game();
		GameView view = new GameView();
		view.setModel(model);
		ZombieProjectWebApp.instance.setView(view);
	}
}
