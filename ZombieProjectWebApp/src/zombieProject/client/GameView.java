package zombieProject.client;

import zombieProject.client.EndGameView;
import zombieProject.shared.Game;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Image;


public class GameView extends Composite{
	
	private Game model;
	
	private Canvas canvas;
	private Timer timer;

	private int counter = 0;
	private int addz = 0;

	private final double WIDTH = 4.0;
	private final double HEIGHT = 4.0;
	
	private final int pSpeed = 3;

	
	private int up=0;
	private int down=0;
	private int left=0;
	private int right=0;
	
	//private Game game;
	
	
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
					
		timer = new Timer() {
			@Override
			public void run() {
				handleTimerTick();
			}
		};
		timer.scheduleRepeating(1000 / 60);

		
	}
	
	protected void handleKeyDown(KeyDownEvent event){//reacts when keys are pressed
		if(event.getNativeKeyCode() == 87){//keycode for 'W'
			this.up=1;
		}
		if(event.getNativeKeyCode() == 83){//keycode for 'S'
			this.down=1;
		}
		if(event.getNativeKeyCode() == 65){//keycode for 'A'
			this.left=1;
		}
		if(event.getNativeKeyCode() == 68){//keycode for 'D'
			this.right=1;
		}
		if(event.isShiftKeyDown()){
			endGame();
			
			
		}
	}
	protected void endGame() {
		this.model.getPlayer().increaseHealth(1000000);
		EndGameView endview = new EndGameView();
		ZombieProjectWebApp.instance.setView(endview);
	}
	
	protected void handleKeyUp(KeyUpEvent event){//reacts when keys are released
		if(event.getNativeKeyCode() == 87){//keycode for 'W'
			this.up=0;
		}
		if(event.getNativeKeyCode() == 83){//keycode for 'S'
			this.down=0;
		}
		if(event.getNativeKeyCode() == 65){//keycode for 'A'
			this.left=0;
		}
		if(event.getNativeKeyCode() == 68){//keycode for 'D'
			this.right=0;
		}
	}
	
	public void setModel(Game model) {
		this.model = model;
		
		this.model.getPlayer().setX(100.0);//initiates player's x position
		this.model.getPlayer().setY(100.0);//initiates player's y position
		
//		this.model.getZombie().setX(60.0);//zombie's x
//		this.model.getZombie().setY(30.0);//zombie's y
		this.model.newZombie();
		this.model.newSpawn();
	}
	
	
	protected void handleTimerTick() {
		counter++;
		addz++;
		if(addz==60){
			addz=0;
			this.model.newZombie();
			this.model.newSpawn();
		}
		if(counter == 5){
			counter = 0;
			for(int i = 0; i < this.model.listSize(); i++){
				this.model.getZombie(i).zMove(this.model.getPlayer());
				if(this.model.getZombie(i).getX()==this.model.getPlayer().getX() && this.model.getZombie(i).getY()==this.model.getPlayer().getY()){
					this.model.getPlayer().decreaseHealth(1);
				}
			}
			for(int i = 0; i < this.model.spawnSize(); i++){
				if(this.model.getSpawned(i).getX()<this.model.getPlayer().getX() + 4 && this.model.getSpawned(i).getY()<this.model.getPlayer().getY() + 4 &&this.model.getSpawned(i).getX()>this.model.getPlayer().getX() - 4 && this.model.getSpawned(i).getY()>this.model.getPlayer().getY() - 4){
					this.model.getPlayer().increaseHealth(10);
					this.model.removeS(i);
				}
			}
			if(this.up==1){
				model.getPlayer().setY(model.getPlayer().getY()-this.pSpeed);
			}
			if(this.down==1){
				model.getPlayer().setY(model.getPlayer().getY()+this.pSpeed);
			}
			if(this.left==1){
				model.getPlayer().setX(model.getPlayer().getX()-this.pSpeed);
			}
			if(this.right==1){
				model.getPlayer().setX(model.getPlayer().getX()+this.pSpeed);
			}
		}
		
		reset();
		paint();
		
	}

	private void reset() {
		canvas.getContext2d().clearRect(0.0, 0.0, 1000.0, 1000.0);
		//canvas.getContext(GWT.getModuleBaseURL() + "Floorpic.jpg");
	}

	private void paint() {
		
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
		canvas.getContext2d().fillRect(this.model.getPlayer().getX(), this.model.getPlayer().getY(), WIDTH, HEIGHT);//x and y; width and height
		
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		for(int i = 0; i < this.model.listSize(); i++){
			canvas.getContext2d().fillRect(this.model.getZombie(i).getX(), this.model.getZombie(i).getY(), WIDTH, HEIGHT);//x and y; width and height
		}
		
		//health pack
		canvas.getContext2d().setFillStyle("#FF0000");//red
		
		for(int i = 0; i < this.model.spawnSize(); i++){
			canvas.getContext2d().fillRect(this.model.getSpawned(i).getX()-1, this.model.getSpawned(i).getY()-3, 2, 6);
			canvas.getContext2d().fillRect(this.model.getSpawned(i).getX()-3, this.model.getSpawned(i).getY()-1, 6, 2);
		}
		

		
		
		
		//health bar
		canvas.getContext2d().setFillStyle("#000000");//black
		canvas.getContext2d().fillRect(10.0, 135.0, 250.0, HEIGHT);
		canvas.getContext2d().setFillStyle("#FF0000");//red
		canvas.getContext2d().fillRect(10.0, 135.0, 250.0*(this.model.getPlayer().getHealth()/100), HEIGHT);
		
	}
}
