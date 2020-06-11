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
	

	
	private String text ;
	private String button_text;
	private int width=300,height=100;
	int x=500,y=300;
	
	public MenuState(Game game){
		super(game);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

		if(Handler.getMouseManager().isLeftPressed()&&
				(Handler.getMouseManager().getMouseX()>=x && Handler.getMouseManager().getMouseX()<=(x+width))&&
				(Handler.getMouseManager().getMouseY()>=y && Handler.getMouseManager().getMouseY()<=(y+height)))
		{
			State.setState(Handler.getGame().gamestate);
			
		}

	}

	@Override
	public void render() {
		Handler.drawStaticRect(x, y, width, height, Color.darkGray);
		Handler.drawStatictext_forMenu(Color.white,button_text, x+80, y+70);
		Handler.drawStatictext_forMenu(Color.black,text, x+80, y-90);

	}
	
	public void set_values(int width,String text,String button_text) {
		this.text = text;
		this.button_text = button_text;
		this.width=width;

	}
}
