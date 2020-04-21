package GameLib;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gfx.Assets;


public abstract class Sprite {
	protected float x,y;
	protected int width,height;
	protected Game game;
	protected BufferedImage Image;
	protected float xMove,yMove;
	protected Rectangle rect;
	protected BufferedImage sprite_images[];
	protected int last_dir;
	
	public Sprite(float x,float y,int width,int height,Game game) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.game = game;
		sprite_images = new BufferedImage[4];
	}

	
	
	public abstract void update();
	
	public void draw() {
		Handler.getGraphics().drawImage(sprite_images[last_dir], (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}
	
	public float right() {return x+width;}
	public float bottom() {return y+height;}
	public float left() {return x;}
	public float top() {return y;}
	public float middle() {return x+width/2;}
	
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
	
	protected boolean isSolid(int x, int y){
		return game.getgamestate().getWorld().getTile(x, y).isSolid();
	}
	
	
	public void destroy() {
		//game.getgamestate().sprites.remove(this);
	}
	
	
}
