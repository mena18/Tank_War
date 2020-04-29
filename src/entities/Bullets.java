package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;

import java.awt.Rectangle;

import GameLib.Sprite;
public class Bullets extends Sprite{

	int speed;
	Tank tank;
	Player player;
		
	public Bullets(float x, float y,Player player, Game game,float mx,float my) {
		super(x, y, 12, 21, game,Assets.red_bullet);
		rect = new Rectangle(0,0,width,height);
		speed=9;
		this.player=player;
		float sqr = (float)Math.sqrt((mx*mx)+(my*my));
		xMove = (mx)/sqr*speed;
		yMove = (my)/sqr*speed;
		game.getgamestate().player_bullets.add(this);

		// TODO Auto-generated constructor stub
	}
	
	public Bullets(float x, float y,Tank tank, Game game,float xMove,float yMove) {
		super(x, y, 12, 21, game,Assets.red_bullet);
		rect = new Rectangle(0,0,width,height);
		speed=9;
		this.tank=tank;
		this.xMove = xMove;
		this.yMove = yMove;
		game.getgamestate().player_bullets.add(this);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		move();
	}
	
	public void destroy() {
		game.getgamestate().player_bullets.remove(this);
	}
	
	public Player get_player() {
		return this.player;
	}
	
	public Tank get_tank() {
		return this.tank;
	}
	
	@Override
	public void collisionWithTileAction() {
		this.destroy();
	}

}
