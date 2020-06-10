package entities;

import java.awt.Rectangle;

import gfx.Assets;
import tilegame.Game;

public class EnemyBullets extends Bullet{
	public EnemyBullets(float x, float y,Tank tank, Game game,float xMove,float yMove) {

		super(x, y, game,Assets.red_bullet);
		rect = new Rectangle(0,0,width,height);
		speed=9;
		this.tank=tank;
		this.xMove = xMove;
		this.yMove = yMove;
		game.getgamestate().enemy_bullets.add(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		game.getgamestate().enemy_bullets.remove(this);
		
	}
}



