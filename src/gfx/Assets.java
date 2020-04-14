package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player,enemy,grass,dirt,rock,wall;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("sheet.png"));
		player = sheet.crop(128, 0, width, height);
		enemy = sheet.crop(128,64, width, height);
		grass = sheet.crop(64,0, width, height);
		rock = sheet.crop(0,64, width, height);
		wall = sheet.crop(96,0, width, height);
		dirt = sheet.crop(32,0, width, height);
	}
	
}
