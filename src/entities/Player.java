package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import GameLib.Sprite;
import gfx.Assets;
import states.State;
import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

public class Player extends Tank{
	private int score=0;
	private int previous_score=0;
	
	public Player(float x, float y, int width, int height, Game game) {
		super(x, y, width, height, game,100,Assets.player_body,Assets.player_canon);
		speed=4;
		health=100;
		shoot_speed=4;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		get_input();
		get_dir();
		move(); // check collision with tiles then move or stop
		float one = game.getMouseManager().getMouseX()+game.getGameCamera().getxOffset()-this.centerX();
		float two = game.getMouseManager().getMouseY()+game.getGameCamera().getyOffset()-this.centerY();
		degree = Math.atan2(two,one) - Math.PI/2;
		
		if(game.getMouseManager().isLeftPressed()) {
			this.shoot(one,two,degree);
		}
		
		
			
	}
	
	public void shoot(float one,float two,double degree) {
		if(System.nanoTime() - last_shot > 1000000000/shoot_speed) {
			PlayerBullets bullet = new PlayerBullets(this.centerX()-6, this.centerY(),this, game,one,two,degree);
			
			last_shot = System.nanoTime();
		}
	}
	
	
	
	
	private void get_input() {
		yMove = 0;
		xMove = 0;
		if(game.getKeyManager().up) {
			yMove = -speed;
		}
		if(game.getKeyManager().down) {
			yMove = speed;
		}
		if(game.getKeyManager().left) {
			xMove = -speed;
		}
		if(game.getKeyManager().right) {
			xMove = speed;
		}
		if(Math.abs(xMove)== Math.abs(yMove)) {
			xMove /= Math.sqrt(2);
			yMove /= Math.sqrt(2);
		}
	}
	
	public void draw() {
		
		Handler.drawStaticRect(730,30,200,20,Color.RED);
		Handler.drawStaticRect(730,30,(int)((1.0*health/max_health)*200),20,Color.GREEN);
		Handler.drawStatictext("Score : "+this.score, 730, 70);
		
		super.draw();
		
		

	}
	
	public int get_score() {
		return this.score;
	}
	public int get_pr_score() {
		return this.previous_score;
	}
	public int get_health() {
		return this.health;
	}
	
	public void set_score(int score) {
		this.score = score;
	}
	public void inc_score(int score) {
		this.score += score;
	}
	
	public void set_position(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
	public void increase_speed() {
		shoot_speed++;
		speed++;
	}
	
	public void destroy() {
		game.getgamestate().level.current_level=1;
		game.menustate.set_values(500,"Game Over","play Again");
		State.setState(game.menustate);
		game.getgamestate().level.level_1();
		reset();
	}
	
	public void reset() {
		previous_score = score;
		score=0;
		health=100;
		speed=4;
		shoot_speed=4;
	}
	
	
	
	
	
}
