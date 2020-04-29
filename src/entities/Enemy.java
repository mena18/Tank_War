package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;

import java.awt.image.BufferedImage;

import GameLib.Sprite;
public class Enemy extends Sprite{
private float yMove,xMove,speed;
	
	public Enemy(float x, float y, int width, int height,BufferedImage Image ,Game game) {
		super(x, y, width, height, game,100);
		this.Image = Image;
		sprite_images[0] = Image;
		speed=2;
		yMove=-1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		y+=yMove;
	}
	
	public void destroy() {
		game.getgamestate().enemy_tanks.remove(this);
		new Explosions((int)x,(int)y,128,128);
	}
	
	public void undo() {
		y-=yMove;
	}
	

}
