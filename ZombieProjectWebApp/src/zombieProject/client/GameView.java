
package zombieProject.client;


import zombieProject.shared.Game;



//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;


import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Image;


public class GameView extends Composite{
	
	private Game model;
	
	private Canvas canvas;
	private Timer timer;



	private int counter=0;


	private Game game;

	private double playerX;
	private double playerY;



	private final double WIDTH = 4.0;
	private final double HEIGHT = 4.0;

	
	private int up=0;
	private int down=0;
	private int left=0;
	private int right=0;

	private double mouseX;
	private double mouseY;
	
	private double slope; //slope value to make bullet go towards the zombie
	
	public GameView() {
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
		//TODO: draw this image to the background---------------------------<<<
//		Image bground = new Image();
//		bground.setUrl(GWT.getModuleBaseURL() + "Floorpic.jpg");
//		layoutPanel.add(bground);
		
		
		this.canvas = Canvas.createIfSupported();
		canvas.setWidth("800px");
		canvas.setHeight("600px");
		layoutPanel.add(canvas);
		layoutPanel.setWidgetLeftWidth(canvas, 40.0, Unit.PX, 800.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(canvas, 30.0, Unit.PX, 600.0, Unit.PX);
		
		
		
		canvas.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event){
				handleKeyDown(event);
			}		
		});
		
		canvas.addKeyUpHandler(new KeyUpHandler(){
			@Override
			public void onKeyUp(KeyUpEvent event) {
				handleKeyUp(event);
				
			}

		});
		
		canvas.addMouseDownHandler(new MouseDownHandler(){

			@Override
			public void onMouseDown(MouseDownEvent event) {
				onMouseDown(event);
				
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
	
	protected void onMouseDown(MouseDownEvent event){
		//fill with bullet creation, velocity, etc.
		mouseX = event.getX();
		mouseY = event.getY();
		
		
	}
	
	protected void handleKeyDown(KeyDownEvent event){//reacts when keys are pressed
		if(event.isUpArrow()){
			model.getPlayer().setY(model.getPlayer().getY() - 4);
		}
		if(event.isDownArrow()){
			model.getPlayer().setY(model.getPlayer().getY() + 4);
		}
		if(event.isLeftArrow()){
			model.getPlayer().setX(model.getPlayer().getX() - 4);
		}
		if(event.isRightArrow()){
			model.getPlayer().setX(model.getPlayer().getX() + 4);
		}
	}
	
	protected void handleKeyUp(KeyUpEvent event){//reacts when keys are released
		if(event.isUpArrow() || event.isDownArrow()){
			model.getPlayer().setY(model.getPlayer().getY());
		}
		if(event.isLeftArrow() || event.isRightArrow()){
			model.getPlayer().setX(model.getPlayer().getX());
		}
	}
	
	
	
	
	public void setModel(Game model) {
		this.model = model;
		
		this.model.getPlayer().setX(100.0);//initiates player's x position
		this.model.getPlayer().setY(100.0);//initiates player's y position
		
//		this.model.getZombie().setX(60.0);//zombie's x
//		this.model.getZombie().setY(30.0);//zombie's y
		this.model.newZombie();
	}
	
	
	protected void handleTimerTick() {
		counter++;
		if(counter == 5){
			counter = 0;

//			for(the array of zombies){
				this.model.getZombie().zMove(this.model.getPlayer());
//			}

			for(int i = 0; i < this.model.listSize(); i++){
				this.model.getZombie(i).zMove(this.model.getPlayer());
			}
			if(this.up==1){
				model.getPlayer().setY(model.getPlayer().getY()-3);
			}
			if(this.down==1){
				model.getPlayer().setY(model.getPlayer().getY()+3);
			}
			if(this.left==1){
				model.getPlayer().setX(model.getPlayer().getX()-3);
			}
			if(this.right==1){
				model.getPlayer().setX(model.getPlayer().getX()+3);
			}

		}
		reset();
		paint();
		
	}

	private void reset() {

		canvas.getContext2d().clearRect(canvas.getAbsoluteLeft(), canvas.getAbsoluteTop(), canvas.getOffsetWidth(), canvas.getOffsetHeight());

		canvas.getContext2d().clearRect(0.0, 0.0, 1000.0, 1000.0);


		

		//canvas.getContext(GWT.getModuleBaseURL() + "Floorpic.jpg");

	}

	private void paint() {


		double playerX = game.getPlayer().x;
		double playerY = game.getPlayer().y; 
		
		double zombieX = game.getZombie().x;
		double zombieY = game.getZombie().y;


		
		Image bground = new Image();
		bground.setUrl(GWT.getModuleBaseURL() + "Floorpic.jpg");
		ImageElement imgElmt = ImageElement.as(bground.getElement());
		
		canvas.getContext(bground.getUrl());
		canvas.getContext2d().drawImage(imgElmt, 0.0, 0.0, 100.0, 75.0);// UL
		canvas.getContext2d().drawImage(imgElmt, 100.0, 0.0, 100.0, 75.0);// UM
		canvas.getContext2d().drawImage(imgElmt, 0.0, 75.0, 100.0, 75.0);// LL
		canvas.getContext2d().drawImage(imgElmt, 100.0, 75.0, 100.0, 75.0);// LM
		canvas.getContext2d().drawImage(imgElmt, 200.0, 0.0, 100.0, 75.0);// UR
		canvas.getContext2d().drawImage(imgElmt, 200.0, 75.0, 100.0, 75.0);// LR

		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#FFCC99");//human color


		canvas.getContext2d().fillRect(playerX, playerY, 4.0, 4.0);//x and y; width and height
		
	//	double zombieX = game.getZombieX(game.zombie);    //*********************CHANGE WHEN ZOMBIES ARE MADE INTO AN ARRAY**********************//
		//double zombieY = game.getZombieY(game.z);
		
		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(zombieX, zombieY, 4.0, 4.0);//x and y; width and height
		

		//bullet lines
		canvas.getContext2d().setFillStyle("#000000");
		canvas.getContext2d().fillRect(playerX, playerY, .5, .5); //put the bullet at the player's top left point
		
		slope = (mouseY - playerY)/(mouseX-playerX);
		
		
		
		canvas.getContext2d().fillRect(playerX, playerY, WIDTH, HEIGHT);//x and y; width and height


		canvas.getContext2d().fillRect(this.model.getPlayer().getX(), this.model.getPlayer().getY(), WIDTH, HEIGHT);//x and y; width and height

		
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		for(int i = 0; i < this.model.listSize(); i++){
			canvas.getContext2d().fillRect(this.model.getZombie(i).getX(), this.model.getZombie(i).getY(), WIDTH, HEIGHT);//x and y; width and height
		}
		
	}
	
	
	
	private void
}
