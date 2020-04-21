package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import GameLib.Sprite;
import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

public class Player extends Sprite{
	private float speed;
	private float last_shot = 0;
	private float shoot_speed = 1000000000/5;

	
	public Player(float x, float y, int width, int height, Game game) {
		super(x, y, width, height, game);
		Image = Assets.player;
		sprite_images[0] = Assets.player; // down
		sprite_images[1] = Assets.rotate(Assets.player, 1); // left
		sprite_images[2] = Assets.rotate(Assets.player, 2); // up 
		sprite_images[3] = Assets.rotate(Assets.player, 3); // right
		speed=3;
		
		rect = new Rectangle(5,5,(int)(width*0.8),(int)(height*0.8));
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		get_input();
		collisionWithTile(); // check collision with tiles then move or stop
		if(game.getKeyManager().space && System.nanoTime() - last_shot > shoot_speed) {
			Bullets bullet = new Bullets(this.middle()-6, y,last_dir, game);
			game.getgamestate().player_bullets.add(bullet);
			last_shot = System.nanoTime();
		}
			
	}
	
	
	
	
	private void get_input() {
		yMove = 0;
		xMove = 0;
		if(game.getKeyManager().up) {
			yMove = -speed;last_dir=2;
		}
		if(game.getKeyManager().down) {
			yMove = speed;last_dir=0;
		}
		if(game.getKeyManager().left) {
			xMove = -speed;last_dir=1;
		}
		if(game.getKeyManager().right) {
			xMove = speed;last_dir=3;
		}
		if(Math.abs(xMove)== Math.abs(yMove)) {
			xMove /= Math.sqrt(2);
			yMove /= Math.sqrt(2);
		}
	}
	
	
	
	
}
