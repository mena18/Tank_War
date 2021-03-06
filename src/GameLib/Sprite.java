package GameLib;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.PlayerBullets;
import gfx.Assets;
import gfx.Explosions;


public abstract class Sprite {
	protected float x,y;
	protected int width,height;
	protected Game game;
	
	protected BufferedImage Image;
	protected int last_dir;
	
	protected float xMove,yMove;
	protected Rectangle rect;
	
	
	public Sprite(float x,float y,int width,int height,Game game,BufferedImage Image) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.game = game;
		this.Image=Image;
		rect = new Rectangle(5,5,(int)(width*0.8),(int)(height*0.8));
	}

	
	
	public abstract void update();
	
	public void draw() {
		Handler.drawImage(Image,x,y, width, height);
	}
	

	
	public float right() {return x+width;}
	public float bottom() {return y+height;}
	public float left() {return x;}
	public float top() {return y;}
	public float centerX() {return x+width/2;}
	public float centerY() {return y+height/2;}
	
	public float getX() {return x;}
	public float getY() {return y;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	
	public void move(){
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

	
	protected boolean isSolid(int x, int y){
		return game.getgamestate().getWorld().getTile(x, y).isSolid();
	}
	
	
	public void destroy() {
		//game.getgamestate().sprites.remove(this);
	}
	

	
	
}
