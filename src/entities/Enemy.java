package entities;

import gfx.Assets;
import tilegame.Game;

import java.awt.image.BufferedImage;

import GameLib.Sprite;
public class Enemy extends Sprite{
private float yMove,xMove,speed;
	
	public Enemy(float x, float y, int width, int height,BufferedImage Image ,Game game) {
		super(x, y, width, height, game);
		this.Image = Image;
		sprite_images[0] = Image;
		speed=2;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		
	}

}
