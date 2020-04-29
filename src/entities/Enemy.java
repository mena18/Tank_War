package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;
import tilegame.Handler;

import java.awt.Color;
import java.awt.image.BufferedImage;

import GameLib.Sprite;
public class Enemy extends Tank{

	public Enemy(float x, float y, int width, int height,Game game) {
		super(x, y, width, height, game,100,Assets.enemy1_body,Assets.enemy1_canon);
		xMove=2;
		speed=3;
		degree=-Math.PI/2;

		// TODO Auto-generated constructor stub
	}
	


	@Override
	public void update() {
		get_dir();
		this.move();
		//this.shoot();
	}
	
	
	public void destroy() {
		game.getgamestate().enemy_tanks.remove(this);
		new Explosions((int)x,(int)y,128,128);
	}
	
	public void draw() {
		Handler.drawRect(x,y-20,50,10,Color.RED);
		Handler.drawRect(x,y-20,(int)((1.0*health/max_health)*50),10,Color.GREEN);
		super.draw();
	}
	

}
