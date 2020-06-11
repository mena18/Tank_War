package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;
import tilegame.Handler;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import GameLib.Sprite;
public abstract class Bullet extends Sprite{

	float speed;
	Tank tank;
	Player player;
	double degree;
		
	public Bullet(float x, float y, Game game,BufferedImage image,double degree) {
		super(x, y, 12, 21, game,image);
		rect = new Rectangle(0,0,width,height);
		speed=9;
		this.degree=degree;

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
	
	public void draw() {
		Graphics2D g = (Graphics2D)Handler.getGraphics().create(); 
		AffineTransform at  = new AffineTransform(); 
		at.rotate(degree, this.centerX()-game.getGameCamera().getxOffset(), (this.centerY()) - game.getGameCamera().getyOffset() ); //<- your question: rotate around specified point
		g.setTransform(at); //<- tell the graphics to transform before painting
		Handler.drawtransImage(g, Image, x, y,width,height);
	}

}
