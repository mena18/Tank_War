package states;

import java.awt.*;

import GameLib.MouseManager;
import display.Display;
import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import GameLib.Music;

public class MenuState extends State{
	public Display display;

	public MenuState(Game game)
	{
		super(game);

	}
	int x=500;int y= 300;
	public  int xBound=600;
	public int yBound=400;
	@Override
	public void tick() {
		// TODO Auto-generated method stub

		if(Handler.getMouseManager().isLeftPressed()&&
				(Handler.getMouseManager().getMouseX()>=500 && Handler.getMouseManager().getMouseX()<=800)&&
				(Handler.getMouseManager().getMouseY()>=300 &&Handler.getMouseManager().getMouseY()<=400))
		{
			State.setState(Handler.getGame().gamestate);
			new Music(Assets.music_loop).loop();
		}

	}

	@Override
	public void render() {
		Handler.drawStaticRect(500, 300, 300, 100, Color.darkGray);
		Handler.drawStatictext_forMenu("start", 579, 369);
		if(Handler.getMouseManager().isLeftPressed()&&
				(Handler.getMouseManager().getMouseX()>=500 && Handler.getMouseManager().getMouseX()<=800)&&
				    (Handler.getMouseManager().getMouseY()>=300 &&Handler.getMouseManager().getMouseY()<=400))
		{
			Handler.drawStaticRect(500, 300, 300, 100, Color.lightGray);
			Handler.drawStatictext_forMenu("start", 579, 369);
		}
	}
}
