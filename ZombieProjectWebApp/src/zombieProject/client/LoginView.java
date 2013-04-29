package zombieProject.client;

import zombieProject.server.DB;
import zombieProject.server.FakeDatabase;
import zombieProject.shared.IDatabase;
import zombieProject.shared.User;
import zombieProject.client.ZombieView;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Image;

	public class LoginView extends Composite{
		

			private Button startButton;
			private RichTextArea UsernameBox;
			private RichTextArea PasswordBox;
			//private RichTextArea titleBox;
			private LayoutPanel layoutPanel;
			public LoginView() {
				
				layoutPanel = new LayoutPanel();
				initWidget(layoutPanel);
				layoutPanel.setSize("1275px", "601px");
				
				Image image = new Image();
				image.setUrl(GWT.getModuleBaseURL() + "ZombieProjectMainPage2.png");// initial screen
				image.setSize("100%", "100%");
				layoutPanel.add(image);
				layoutPanel.setWidgetLeftRight(image, 15.0, Unit.PX, 48.0, Unit.PX);
				layoutPanel.setWidgetTopBottom(image, 0.0, Unit.PX, 0.0, Unit.PX);
				final User user = new User();
				
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
				//add stuff here for keypress enter
				
				startButton = new Button("New button");
				startButton.setText("Sign In");
				startButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						if(DB.instance().logIn(UsernameBox.getText(), PasswordBox.getText()) != null){
							handleStartZview();
						}else{
							startButton.setText("Retry Login Input");
						}
					}
				});
				
				startButton.setStyleName("sendButton");
				layoutPanel.add(startButton);
				startButton.setSize("40", "10");
				layoutPanel.setWidgetLeftWidth(startButton, 40.9, Unit.EM, 11.0, Unit.EM);
				layoutPanel.setWidgetBottomHeight(startButton, 0.0, Unit.EM, 4.5, Unit.EM);
				
				TextBox txtbxUsername = new TextBox();
				txtbxUsername.setStyleName("dialogVPanel");
				txtbxUsername.setReadOnly(true);
				txtbxUsername.setText("Username:");
				layoutPanel.add(txtbxUsername);
				layoutPanel.setWidgetLeftWidth(txtbxUsername, 453.0, Unit.PX, 100.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(txtbxUsername, 217.0, Unit.PX, 34.0, Unit.PX);
				
				TextBox txtbxPassword = new TextBox();
				txtbxPassword.setText("Password:");
				txtbxPassword.setStyleName("dialogVPanel");
				txtbxPassword.setReadOnly(true);
				layoutPanel.add(txtbxPassword);
				layoutPanel.setWidgetLeftWidth(txtbxPassword, 453.0, Unit.PX, 100.0, Unit.PX);
				layoutPanel.setWidgetTopHeight(txtbxPassword, 280.0, Unit.PX, 34.0, Unit.PX);
					
			}
			
			
			protected void handleStartZview() {
				
				ZombieView Zombiview = new ZombieView();
				ZombieProjectWebApp.instance.setView(Zombiview);
				
				
			}
		}
