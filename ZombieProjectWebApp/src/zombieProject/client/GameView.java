package zombieProject.client;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;


public class GameView extends Composite {
	
	private Canvas canvas;
	private Timer timer;
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
		
		timer = new Timer() {
			@Override
			public void run() {
				handleTimerTick();
			}
		};
		timer.scheduleRepeating(1000 / 60);
	}

	protected void handleTimerTick() {
		paint();
	}

	private void paint() {
		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#FFCC99");//human color
		canvas.getContext2d().fillRect(playerX, playerY, WIDTH, HEIGHT);//x and y; width and height
		
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(10.0, 10.0, WIDTH, HEIGHT);//x and y; width and height
	}
//	@Override
//	public void keyPressed(KeyEvent e) {
//		int keycode = e.getKeyCode();
//		if(keycode == KeyEvent.VK_UP){//moves player up
//			playerY = playerY - 5;
//		}
//		else if(keycode == KeyEvent.VK_DOWN){//moves player down
//			playerY = playerY + 5;
//		}
//		else if(keycode == KeyEvent.VK_LEFT){//moves player left
//			playerX = playerX - 5;
//		}
//		else if(keycode == KeyEvent.VK_RIGHT){
//			playerX = playerX + 5;
//		}
//	}
//
//	//dont need
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	//dont need
//	
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

	
	
}
