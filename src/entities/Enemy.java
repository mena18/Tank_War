package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

import java.awt.Color;
import java.awt.image.BufferedImage;

import GameLib.Sprite;
public class Enemy extends Tank{
	boolean shooting;
	float range;
	public Enemy(float x, float y, int width, int height,Game game) {
		super(x, y, width, height, game,100,Assets.enemy1_body,Assets.enemy1_canon);
		xMove=0;
		yMove=0;
		speed=2;
		degree=13;
		shoot_speed=500000000;
		shooting = false;
		range=500;
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public void update() {
		float one=0,two=0;
		if(player_distance() <= range) {
			shooting=true;
			one = game.getgamestate().player.getX()-this.centerX();
			two = game.getgamestate().player.getY()-this.centerY();
			degree = Math.atan2(two,one) - Math.PI/2;
		}else if(base_distance() <= range){
			shooting=true;
			one = game.getgamestate().base.getX()-this.centerX();
			two = game.getgamestate().base.getY()-this.centerY();
			degree = Math.atan2(two,one) - Math.PI/2;
		}else {
			shooting=false;
		}

		make_direction_base_on_tile();
		get_dir();
		this.move();
		this.shoot(one,two);
	}
	
	public void make_direction_base_on_tile() {
		int tx = (int) (x + rect.x + rect.width) / Tile.TILEWIDTH;
		int ty = (int) (y +  rect.y + rect.height) / Tile.TILEHEIGHT;
		if(!isSolid(tx+3,ty)) {
			xMove=speed;
			yMove=0;
		}else if(!isSolid(tx,ty+3)) {
			yMove=speed;
			xMove=0;
		}else {
			yMove=0;
			xMove=0;
		}
		
	}
	
	protected boolean isSolid(int x, int y){
		return game.getgamestate().getWorld().getTile(x, y).isSolid();
	}
	
	public double player_distance() {
		float o = this.x-game.getgamestate().player.getX();
		float s = this.y-game.getgamestate().player.getY();
		return Math.sqrt(o*o + s*s);
	}
	
	public double base_distance() {
		float o = this.x-game.getgamestate().base.getX();
		float s = this.y-game.getgamestate().base.getY();
		return Math.sqrt(o*o + s*s);
	}
	
	public void shoot(float one,float two) {
		if(System.nanoTime() - last_shot > shoot_speed && shooting) {
			EnemyBullets bullet = new EnemyBullets(this.centerX()-6, this.centerY(),this, game,one,two);
			last_shot = System.nanoTime();
		}
	}
	
	
	public void destroy() {
		game.getgamestate().enemy_tanks.remove(this);
		new Explosions((int)x,(int)y,128,128);
		if(Math.random()<=0.3)
			game.getgamestate().bonus_factory.create_bonus(x,y);
	}
	
	public void draw() {
		Handler.drawRect(x,y-20,50,10,Color.RED);
		Handler.drawRect(x,y-20,(int)((1.0*health/max_health)*50),10,Color.GREEN);
		super.draw();
	}
	

}
