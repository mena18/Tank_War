package entities;

import gfx.Assets;
import tilegame.Game;

import java.awt.Rectangle;

import GameLib.Sprite;
public class Bullets extends Sprite{

	int speed;
	public Bullets(float x, float y, int width, int height, Game game,int speed) {
		super(x, y, width, height, game);
		Image = Assets.laser;
		this.speed=speed;
		this.yMove=-5;
		// TODO Auto-generated constructor stub
	}
	
	public Bullets(float x, float y, Game game) {
		super(x, y, 12, 21, game);
		Image = Assets.red_bullet;
		this.yMove=-5;
		rect = new Rectangle(0,0,width,height);
		// TODO Auto-generated constructor stub
	}
	
	public Bullets(float x, float y, Game game,int speed) {
		super(x, y, 12, 21, game);
		Image = Assets.red_bullet;
		this.speed=speed;
		this.yMove=-5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		collisionWithTile();
		if(y<=0) {
			destroy();
		}
	}
	
	public void destroy() {
		game.getgamestate().player_bullets.remove(this);
	}
	
	@Override
	public void collisionWithTileAction() {
		this.destroy();
	}

}
