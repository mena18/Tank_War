package entities;

import java.awt.Rectangle;

import gfx.Assets;
import tilegame.Game;

public class EnemyBullets extends Bullet{
	public EnemyBullets(float x, float y,Tank tank, Game game,float mx,float my,double degree) {

		super(x, y, game,Assets.red_bullet,degree);
		rect = new Rectangle(0,0,width,height);
		speed=7;
		this.tank=tank;
		float sqr = (float)Math.sqrt((mx*mx)+(my*my));
		xMove = (mx)/sqr*speed;
		yMove = (my)/sqr*speed;
		game.getgamestate().enemy_bullets.add(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		game.getgamestate().enemy_bullets.remove(this);
		
	}
}



