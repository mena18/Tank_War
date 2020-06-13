package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gfx.Assets;
import tilegame.Handler;

public class Tile {

	//STATIC STUFF HERE

	public static Tile[] tiles = new Tile[256];
	public static Tile grass1 = new Tile(Assets.grass1,0);
	public static Tile road = new Tile(Assets.road,1);
	
	public static Tile sand1 = new Tile(Assets.sand1,3);

	public static Tile grass2 = new Tile(Assets.grass2,4);
	public static Tile sand2 = new Tile(Assets.sand2,5);
	
	public static Tile wall = new Tile(Assets.wall,2,true);
	public static Tile wood = new Tile(Assets.wood,6,true);
	public static Tile metal = new Tile(Assets.metal,7,true);


	public static Tile trans_right = new Tile(Assets.trans_right,8);


	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	protected BufferedImage texture;
	protected final int id;
	protected boolean solid=false;
	
	public Tile(BufferedImage texture, int id,boolean solid){
		this.texture = texture;
		this.id = id;
		this.solid=solid;
		tiles[id] = this;
	}
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}

	public void tick(){

	}

	public void render(int x, int y){
		Handler.getGraphics().drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid(){
		return solid;
	}

	public int getId(){
		return id;
	}

}
