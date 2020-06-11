package entities;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Factory.TankFactory;
import GameLib.Sprite;
import tilegame.Game;
import tilegame.Handler;

public class Base extends Sprite{
	int max_health;
	int health;
	public TankFactory t1;
	public Base(float x, float y, int width, int height, Game game, BufferedImage Image) {
		super(x, y, width, height, game, Image);
		this.max_health=1000;
		this.health=max_health;
		// TODO Auto-generated constructor stub
	}
	
	public Base(float x, float y, int width, int height, Game game, BufferedImage Image,TankFactory t1) {
		super(x, y, width, height, game, Image);
		this.max_health=1000;
		this.health=max_health;
		this.t1=t1;
		t1.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	
	public void reduce_health() {
		this.health-=50;
		if(this.health<=0) {
			this.destroy();
		}
	}
	
	public void destroy() {
		game.getgamestate().enemy_base.remove(this);
		game.getgamestate().Player_base.remove(this);
		this.t1.destroy();
	}
	
	public void draw() {
		Handler.drawRect(x,y-20,100,10,Color.RED);
		Handler.drawRect(x,y-20,(int)((1.0*health/max_health)*100),10,Color.GREEN);
		super.draw();
	}

}
