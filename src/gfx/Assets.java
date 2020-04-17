package gfx;

import java.awt.image.BufferedImage;

import GameLib.ImageLoader;
import GameLib.SpriteSheet;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player,enemy1,enemy2,enemy3;
	public static BufferedImage grass1,grass2,sand1,sand2,wall,road,trans_right;
	public static BufferedImage laser,shield,red_bullet;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("sheet.png"));
		wall = sheet.crop(96,0, width, height);
		
//		grass = sheet.crop(64,0, width, height);
//		rock = sheet.crop(0,64, width, height);
//		dirt = sheet.crop(32,0, width, height);
		
		grass1 = ImageLoader.loadImage("grass1.png");
		grass2 = ImageLoader.loadImage("grass2.png");
		sand1 = ImageLoader.loadImage("sand1.png");
		sand2 = ImageLoader.loadImage("sand2.png");
		road = ImageLoader.loadImage("road.png");
		trans_right = ImageLoader.loadImage("trans_right.png");
		
		player = ImageLoader.loadImage("player.png");
		enemy1 = ImageLoader.loadImage("enemy1.png");
		enemy2 = ImageLoader.loadImage("enemy2.png");
		enemy3 = ImageLoader.loadImage("enemy3.png");
		
		laser = ImageLoader.loadImage("laserBlue16.png");
		red_bullet = ImageLoader.loadImage("red_bullet.png");
		shield = ImageLoader.loadImage("shield_gold.png");
	}
	
}
