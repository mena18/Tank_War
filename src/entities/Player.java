package entities;

import java.awt.Graphics;

import gfx.Assets;
import tilegame.Game;

public class Player extends Creature{


	public Player(float x, float y, int width, int hieght,Game game) {
		super(x, y, width, hieght,game);
		speed=10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		get_input();
		move();
		game.getGameCamera().centerOnEntity(this);
	}
	
	
	public void get_input() {
		yMove = 0;
		xMove = 0;
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}

	
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}



}
