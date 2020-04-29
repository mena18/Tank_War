package entities;

import gfx.Assets;
import tilegame.Game;

import java.awt.Rectangle;

import GameLib.Sprite;
public class Bullets extends Sprite{

	int speed;
	Player player;
		
	public Bullets(float x, float y,Player player, Game game) {
		super(x, y, 12, 21, game,0);
		Image = Assets.red_bullet;
		sprite_images[0] = Assets.red_bullet; // down
		sprite_images[1] = Assets.rotate(Assets.red_bullet, 1); // left
		sprite_images[2] = Assets.rotate(Assets.red_bullet, 2); // up 
		sprite_images[3] = Assets.rotate(Assets.red_bullet, 3); // right
		rect = new Rectangle(0,0,width,height);
		speed=9;
		this.player=player;
		float mx = game.getMouseManager().getMouseX()+game.getGameCamera().getxOffset()-player.centerX();
		float my = game.getMouseManager().getMouseY()+game.getGameCamera().getyOffset()-player.centerY();
		float sqr = (float)Math.sqrt((mx*mx)+(my*my));
		xMove = (mx)/sqr*speed;
		yMove = (my)/sqr*speed;

		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		collisionWithTile();
		
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
