package gfx;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import GameLib.ImageLoader;
import GameLib.SpriteSheet;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player,player_2,enemy1,enemy2;
	public static BufferedImage grass1,grass2,sand1,sand2,wall,road,trans_right;
	public static BufferedImage laser,shield,red_bullet;
	public static BufferedImage explosion1,explosion2,explosion3,explosion4,explosion5;
	
	public static BufferedImage tank_body,canon;
	
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
		player_2 = ImageLoader.loadImage("player_2.png");
		enemy1 = ImageLoader.loadImage("enemy_1.png");
		enemy2 = ImageLoader.loadImage("enemy_2.png");
		
		laser = ImageLoader.loadImage("laserBlue16.png");
		red_bullet = ImageLoader.loadImage("red_bullet.png");
		shield = ImageLoader.loadImage("shield_gold.png");
		
		explosion1 = ImageLoader.loadImage("explosion1.png");
		explosion2 = ImageLoader.loadImage("explosion2.png");
		explosion3 = ImageLoader.loadImage("explosion3.png");
		explosion4 = ImageLoader.loadImage("explosion4.png");
		explosion5 = ImageLoader.loadImage("explosion5.png");
		
		tank_body = ImageLoader.loadImage("tank_body.png");
		canon = ImageLoader.loadImage("canon.png");

		
	}
	
	
	public static BufferedImage rotate(BufferedImage image,int dir){
		dir *=45;
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.PI/2*dir, image.getWidth()/2, image.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);

	}
	
}
