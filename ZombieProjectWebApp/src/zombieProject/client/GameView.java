package zombieProject.client;


import zombieProject.shared.Game;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;


public class GameView extends Composite{
	
	private Game model;
	
	private Canvas canvas;
	private Timer timer;

	private int counter = 0;

	private final double WIDTH = 4.0;
	private final double HEIGHT = 4.0;

	//private Game game;
	
	
	public GameView() {
		LayoutPanel layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		
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
		counter++;
		if(counter == 15){
			counter = 0;
//			for(the array of zombies){
				this.model.getZombie().zMove(this.model.getPlayer());
//			}
		}
		
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
		this.model.getZombie().setX(60.0);//zombie's x
		this.model.getZombie().setY(30.0);//zombie's y
	}
	
	
	protected void handleTimerTick() {
		reset();
		paint();
	}

	private void reset() {
		canvas.getContext2d().clearRect(40.0, 30.0, 800.0, 600.0);
		
	}

	private void paint() {
		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#FFCC99");//human color
		canvas.getContext2d().fillRect(this.model.getPlayer().getX(), this.model.getPlayer().getY(), WIDTH, HEIGHT);//x and y; width and height
		
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(this.model.getZombie().getX(), this.model.getZombie().getY(), WIDTH, HEIGHT);//x and y; width and height
	}
}
