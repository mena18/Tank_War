package GameLib;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.Bullets;
import gfx.Assets;
import gfx.Explosions;


public abstract class Sprite {
	protected float x,y;
	protected int width,height;
	protected Game game;
	protected BufferedImage Image;
	protected float xMove,yMove;
	protected Rectangle rect;
	protected BufferedImage sprite_images[];
	protected int last_dir;
	protected int health=100;
	protected int max_health=100;
	
	public Sprite(float x,float y,int width,int height,Game game,int health) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.game = game;
		sprite_images = new BufferedImage[4];
		this.health=health;
	}

	
	
	public abstract void update();
	
	public void draw() {
		Handler.drawRect(x,y-20,50,10,Color.RED);
		Handler.drawRect(x,y-20,(int)((1.0*health/max_health)*50),10,Color.GREEN);
		Handler.drawImage(sprite_images[last_dir],x,y, width, height);
	}
	

	
	public float right() {return x+width;}
	public float bottom() {return y+height;}
	public float left() {return x;}
	public float top() {return y;}
	public float centerX() {return x+width/2;}
	public float centerY() {return y+height/2;}
	
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void collisionWithTile(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + rect.x + rect.width) / Tile.TILEWIDTH;
			
			if(!isSolid(tx, (int) (y + rect.y) / Tile.TILEHEIGHT) &&
					!isSolid(tx, (int) (y + rect.y + rect.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				collisionWithTileAction();
				//x = tx * Tile.TILEWIDTH - rect.x - rect.width - 1;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + rect.x) / Tile.TILEWIDTH;
			
			if(!isSolid(tx, (int) (y + rect.y) / Tile.TILEHEIGHT) &&
					!isSolid(tx, (int) (y + rect.y + rect.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				collisionWithTileAction();
				//x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - rect.x;
			}
			
		}
		
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + rect.y) / Tile.TILEHEIGHT;
			
			if(!isSolid((int) (x + rect.x) / Tile.TILEWIDTH, ty) &&
					!isSolid((int) (x + rect.x + rect.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				collisionWithTileAction();
				//y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - rect.y;
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + rect.y + rect.height) / Tile.TILEHEIGHT;
			
			if(!isSolid((int) (x + rect.x) / Tile.TILEWIDTH, ty) &&
					!isSolid((int) (x + rect.x + rect.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				collisionWithTileAction();
				//y = ty * Tile.TILEHEIGHT - rect.y - rect.height - 1;
			}
			
		}
	}
	
	public void collisionWithTileAction() {
		
	}
	
	public void reduce_health(int hel) {
		this.health-=hel;
		if(health<=0) {
			this.destroy();
		}
		
	}
	
	public void reduce_health(int hel,Bullets b) {
		this.health-=hel;
		if(health<=0) {
			this.destroy();
			b.get_player().inc_score(25);
		}
	}
	
	protected boolean isSolid(int x, int y){
		return game.getgamestate().getWorld().getTile(x, y).isSolid();
	}
	
	
	public void destroy() {
		//game.getgamestate().sprites.remove(this);
	}
	
	public int get_health() {
		return this.health;
	}
	
	public void set_health(int h) {
		this.health=Math.min(max_health, h);
	}
	
	
}
