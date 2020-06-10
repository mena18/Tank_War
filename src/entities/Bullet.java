package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameLib.Sprite;
public abstract class Bullet extends Sprite{

	float speed;
	Tank tank;
	Player player;
		
	public Bullet(float x, float y, Game game,BufferedImage image) {
		super(x, y, 12, 21, game,image);
		rect = new Rectangle(0,0,width,height);
		speed=9;

		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void update() {
		move();
	}
	
	public abstract void destroy();
	
	
	public Tank get_tank() {
		return this.tank;
	}
	
	@Override
	public void collisionWithTileAction() {
		this.destroy();
	}

}
