package tilegame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Handler {
	
	
	private static Graphics g;
	private static Game game;
	public static void init() {
		
	}
	
	public static void set_Graphics(Graphics g) {
		Handler.g = g;
	}
	
	public static Graphics getGraphics() {
		return g;
	}
	
	public static void drawImage(BufferedImage image,float x,float y,int width,int height) {
		getGraphics().drawImage(image, (int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()), width,height,null);
	}
	
	public static void drawImage(BufferedImage image,float x,float y) {
		getGraphics().drawImage(image, (int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),null);
	}
	
	public static void drawtransImage(Graphics2D g,BufferedImage image,float x,float y,int width,int height) {
		g.drawImage(image, (int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),null);
	}
	
	public static Game getGame() {
		return game;
	}
	public static void setGame(Game game) {
		Handler.game = game;
	}
}
