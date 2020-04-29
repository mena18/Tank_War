package entities;

import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;
import GameLib.Sprite;

public class Bonus extends Sprite{

	public Bonus(float x, float y, int width, int height, Game game) {
		super(x, y, width, height, game,0);
		Image = Assets.shield;
		// TODO Auto-generated constructor stub
	}
	
	public Bonus(float x, float y, Game game) {
		super(x, y, 30, 30, game,0);
		Image = Assets.laser;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	


}
