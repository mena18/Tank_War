package entities;

import java.awt.Graphics;

import gfx.Assets;
import tilegame.Game;

public abstract class Creature extends Entity{
	

	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	
	public Creature(float x, float y, int width, int hieght,Game game) {
		super(x, y, width, hieght,game);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		// TODO Auto-generated constructor stub
	}
	
	public Creature(float x, float y,Game game) {
		super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT,game);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		// TODO Auto-generated constructor stub
	}
	
	public void move(){
		x += xMove;
		y += yMove;
	}



}
