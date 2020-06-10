package entities;

import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;

import java.awt.Rectangle;

import GameLib.Sprite;
public class PlayerBullets extends Bullet{

	Tank tank;
	Player player;
		
	public PlayerBullets(float x, float y,Player player, Game game,float mx,float my) {
		super(x, y, game,Assets.red_bullet);
		this.player=player;
		float sqr = (float)Math.sqrt((mx*mx)+(my*my));
		xMove = (mx)/sqr*speed;
		yMove = (my)/sqr*speed;
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
	
	
	@Override
	public void collisionWithTileAction() {
		this.destroy();
	}

}
