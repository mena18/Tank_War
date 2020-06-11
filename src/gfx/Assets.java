package gfx;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import GameLib.ImageLoader;
import GameLib.SpriteSheet;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player,player_2,enemy1,enemy2;
	
	public static BufferedImage grass1,grass2,sand1,sand2,wall,road,trans_right;
	public static BufferedImage laser,shield,red_bullet;
	public static BufferedImage explosion1,explosion2,explosion3,explosion4,explosion5;
	
	public static BufferedImage player_body,player_canon;
	public static BufferedImage enemy1_body,enemy1_canon;
	
	public static BufferedImage base1,base2,money,upgrade;
	
	public static File shooting1,music_loop;
	
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
		
		player_body = ImageLoader.loadImage("tank_body.png");
		player_canon = ImageLoader.loadImage("canon.png");
		enemy1_body = ImageLoader.loadImage("enemy1_body.png");
		enemy1_canon = ImageLoader.loadImage("enemy1_canon.png");
		
		base1 = ImageLoader.loadImage("base1.png");
		base2= ImageLoader.loadImage("base2.png");
		
		money = ImageLoader.loadImage("money.png");
		upgrade = ImageLoader.loadImage("upgrade.png");
		
		shooting1 = new File("res/audio/playerjump.wav");
		music_loop = new File("res/audio/level 1.wav");

		
		
		
	}
	
	
	public static BufferedImage rotate(BufferedImage image,int dir){
		dir *=45;
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.PI/2*dir, image.getWidth()/2, image.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);

	}
	
}
