package gfx;

import tilegame.Game;
import tiles.Tile;
import entities.Entity;

public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
		if(xOffset<0) {xOffset=0;}
		xOffset = Math.min(xOffset,game.getgamestate().getWorld().getWidth() * Tile.TILEWIDTH - game.getWidth());
		if(yOffset<0) {yOffset=0;}
		yOffset = Math.min(yOffset,game.getgamestate().getWorld().getHeight() * Tile.TILEHEIGHT - game.getHeight());

	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
