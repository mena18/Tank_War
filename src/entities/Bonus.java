package entities;

import java.awt.image.BufferedImage;

import GameLib.Sprite;
import gfx.Assets;
import tilegame.Game;

public abstract class Bonus extends Sprite{
	Player player;
	public Bonus(float x, float y, int width, int height, Game game,Player player,BufferedImage Image) {
		super(x, y, width, height, game,Image);
		this.player=player;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void bonus_effect();
	
	public abstract void destroy() ;
}
