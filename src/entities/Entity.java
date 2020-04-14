package entities;

import java.awt.Graphics;

import tilegame.Game;

public abstract class Entity {
	protected float x,y;
	protected int width,height;
	protected Game game;
	
	public Entity(float x,float y,int width,int height,Game game) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

}
