package zombieProject.client;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.Style.Unit;

public class GameView extends Composite{
	
	private Canvas canvas;
	private Timer timer;
	private Game game;
	
	public GameView() {
		
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
		double playerX = game.getPlayerX();
		double playerY = game.getPlayerY();
		
		canvas.getContext2d().setFillStyle("#FFCC99");//human color
		canvas.getContext2d().fillRect(playerX, playerY, 4.0, 4.0);//x and y; width and height
		
		double zombieX = game.getZombieX();
		double zombieY = game.getZombieY();
		
		// TODO: use Game object to determine what to draw
		canvas.getContext2d().setFillStyle("#008600");//zombie color
		canvas.getContext2d().fillRect(zombieX, zombieY, 4.0, 4.0);//x and y; width and height
		

		
	}
}
