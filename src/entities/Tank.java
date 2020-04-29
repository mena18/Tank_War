package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import GameLib.Sprite;
import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;

public class Tank extends Sprite{

	protected int health,max_health=100;
	protected BufferedImage sprite_images[];
	protected BufferedImage canon;
	protected int speed;
	protected double degree;
	protected float last_shot = 0;
	protected float shoot_speed = 1000000000/5;
	

	
	public Tank(float x, float y, int width, int height, Game game, int health,BufferedImage Image,BufferedImage Image2) {
		super(x, y, width, height, game,Image);
		this.max_health=health;
		this.health=health;
		sprite_images = new BufferedImage[4];
		sprite_images[0] = Image; // down
		sprite_images[1] = Assets.rotate(Image, 1); // left
		sprite_images[2] = Assets.rotate(Image, 2); // up 
		sprite_images[3] = Assets.rotate(Image, 3); // right
		this.canon = Image2;
		

		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw() {
		Handler.drawImage(sprite_images[last_dir],x , y, width, height);
		Graphics2D g = (Graphics2D)Handler.getGraphics().create(); 
		AffineTransform at  = new AffineTransform(); 
		at.rotate(degree, this.centerX()-game.getGameCamera().getxOffset(), (this.centerY()) - game.getGameCamera().getyOffset() ); //<- your question: rotate around specified point
		g.setTransform(at); //<- tell the graphics to transform before painting
		Handler.drawtransImage(g, canon, this.centerX()-8, this.centerY(),16,2*height/3);
	}
	
	
	
	public int get_health() {
		return this.health;
	}
	
	public void set_health(int h) {
		this.health=Math.min(max_health, h);
	}
	
	
	public void reduce_health(int hel) {
		this.health-=hel;
		if(health<=0) {
			this.destroy();
		}
		
	}
	
	public void reduce_health(int hel,Bullets b) {
		this.health-=hel;
		if(health<=0) {
			this.destroy();
			b.get_player().inc_score(25);
		}
	}
	
	public void get_dir() {
		if(xMove>0) {last_dir=3;}
		else if(xMove<0) {last_dir=1;}
		else if(yMove<0) {last_dir=2;}
		else {last_dir=0;}
		
	}
	
	public void undo() {
		y-=yMove;
		x-=xMove;
	}
	
	
	public void shoot() {
		if(System.nanoTime() - last_shot > shoot_speed) {
			new Bullets(this.centerX()-6, this.centerY(),this, game,3,0);
			last_shot = System.nanoTime();
		}
	}
	
	
	

	

}
