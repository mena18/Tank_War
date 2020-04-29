package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
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
	private BufferedImage Canon;
	double degree=0;
	
	public Player(float x, float y, int width, int height, Game game) {
		super(x, y, width, height, game,100);
		//Image = Assets.tank_body;
		Image = Assets.tank_body;
		Canon = Assets.canon;
		sprite_images[0] = Image; // down
		sprite_images[1] = Assets.rotate(Image, 1); // left
		sprite_images[2] = Assets.rotate(Image, 2); // up 
		sprite_images[3] = Assets.rotate(Image, 3); // right
		speed=3;
		
		rect = new Rectangle(5,5,(int)(width*0.8),(int)(height*0.8));
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		get_input();
		collisionWithTile(); // check collision with tiles then move or stop
		double one = game.getMouseManager().getMouseX()+game.getGameCamera().getxOffset()-this.middle();
		double two = game.getMouseManager().getMouseY()+game.getGameCamera().getyOffset()-this.getY();
		degree = Math.atan2(two,one) - Math.PI/2;
		if(game.getMouseManager().isLeftPressed() && System.nanoTime() - last_shot > shoot_speed) {
			Bullets bullet = new Bullets(this.middle()-6, y,this, game);
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
	
	public void draw() {
		Handler.drawImage(sprite_images[last_dir],x , y, width, height);
		Graphics2D g = (Graphics2D)Handler.getGraphics().create(); //<- you should have this in your code somewhere
		AffineTransform at = new AffineTransform(); 
		at.rotate(degree, this.middle()-game.getGameCamera().getxOffset(), (this.getY()+this.getHeight()/2) - game.getGameCamera().getyOffset() ); //<- your question: rotate around specified point
		g.setTransform(at); //<- tell the graphics to transform before painting
		Handler.drawtransImage(g, Canon, this.middle()-8, this.getY()+this.getHeight()/2,16,45);
		//g.drawImage(Canon,); //<- draws transformed image
		
		//Handler.drawImage(Assets.rotate(Canon, 2), this.middle()-8, this.bottom()-32,16,45);
	}
	
	
	
	
}
