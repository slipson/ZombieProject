package src.zombieProject.client;

import zombieProject.shared.Game;


//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
//import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;


public class GameView extends Composite {
	
	private Canvas canvas;
	private Timer timer;

	private int counter=0;


	private Game game;

	private double playerX;
	private double playerY;
	private final double WIDTH = 4.0;
	private final double HEIGHT = 4.0;
	

	//private Game game;

	
	public GameView() {
		playerX = 100.0;
		playerY = 10.0;
		
		
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
//		InlineLabel nlnlblThisIsThe = new InlineLabel("This is the game!");
//		layoutPanel.add(nlnlblThisIsThe);
//		layoutPanel.setWidgetLeftWidth(nlnlblThisIsThe, 109.0, Unit.PX, 202.0, Unit.PX);
//		layoutPanel.setWidgetTopHeight(nlnlblThisIsThe, 25.0, Unit.PX, 18.0, Unit.PX);
		
		this.canvas = Canvas.createIfSupported();
		canvas.setWidth("800px");
		canvas.setHeight("600px");
		layoutPanel.add(canvas);
		layoutPanel.setWidgetLeftWidth(canvas, 20.0, Unit.PX, 800.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(canvas, 100, Unit.PX, 600.0, Unit.PX);
		
		final Button btnUp = new Button("UP");
		layoutPanel.add(btnUp);
		layoutPanel.setWidgetLeftWidth(btnUp, 20.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnUp, 205.0, Unit.PX, 30.0, Unit.PX);
		btnUp.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(btnUp.isEnabled()){
					playerY = playerY - 4;
				}
			}
		});
		
		final Button btnDown = new Button("DWN");
		layoutPanel.add(btnDown);
		layoutPanel.setWidgetLeftWidth(btnDown, 20.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnDown, 270.0, Unit.PX, 30.0, Unit.PX);
		btnDown.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(btnDown.isEnabled()){
					playerY = playerY + 4;
				}
			}
		});
		
		final Button btnLft = new Button("LFT");
		layoutPanel.add(btnLft);
		layoutPanel.setWidgetLeftWidth(btnLft, 0.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnLft, 241.0, Unit.PX, 30.0, Unit.PX);
		btnLft.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(btnLft.isEnabled()){
					playerX = playerX - 4;
				}
			}
		});
		
		final Button btnRt = new Button("RT");
		layoutPanel.add(btnRt);
		layoutPanel.setWidgetLeftWidth(btnRt, 84.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnRt, 241.0, Unit.PX, 30.0, Unit.PX);
		btnRt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(btnRt.isEnabled()){
					playerX = playerX + 4;
				}
			}
		});
		
		timer = new Timer() {
			@Override
			public void run() {
				handleTimerTick();
			}
		};
		timer.scheduleRepeating(1000 / 60);
		counter++;
		if(counter==15){
			counter=0;
//			for(the array of zombies){
//				z.zombieRoam();
//			}
		}
		
	}

	protected void handleTimerTick() {
		reset();
		paint();
	}

	private void reset() {
		canvas.getContext2d().clearRect(getAbsoluteLeft(), getAbsoluteTop(), getOffsetWidth(), getOffsetHeight());
		
	}

	private void paint() {

		double playerX = game.getPlayerX(game.p);
		double playerY = game.getPlayerY(game.p); 
		

		// TODO: use Game object to determine what to draw

		canvas.getContext2d().setFillStyle("#FFCC99");//human color

		canvas.getContext2d().fillRect(playerX, playerY, 4.0, 4.0);//x and y; width and height
		
		double zombieX = game.getZombieX(game.z);    //*********************CHANGE WHEN ZOMBIES ARE MADE INTO AN ARRAY**********************//
		double zombieY = game.getZombieY(game.z);
		
		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(zombieX, zombieY, 4.0, 4.0);//x and y; width and height
		


		canvas.getContext2d().fillRect(playerX, playerY, WIDTH, HEIGHT);//x and y; width and height

		
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(10.0, 10.0, WIDTH, HEIGHT);//x and y; width and height
	}
}
