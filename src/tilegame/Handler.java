package tilegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import GameLib.MouseManager;

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
	
	public static void drawtransImage(Graphics2D g,BufferedImage image,float x,float y) {
		g.drawImage(image, (int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),null);
	}
	
	public static void drawtransImage(Graphics2D g,BufferedImage image,float x,float y,int width,int height) {
		g.drawImage(image, (int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),width,height,null);
	}
	
	public static void drawRect(float x,float y,int width,int height) {
		g.fillRect((int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),width,height);
	}
	public static void drawRect(float x,float y,int width,int height,Color color) {
		g.setColor(color);
		g.fillRect((int) (x-game.getGameCamera().getxOffset()), (int) (y-game.getGameCamera().getyOffset()),width,height);
	}
	
	public static void drawtext(String text,int x,int y) {
		g.setColor(Color.white);
		g.drawString(text,(int) (x-game.getGameCamera().getxOffset()),(int) (y-game.getGameCamera().getyOffset()));
	}
	
	
	public static void drawStaticRect(float x,float y,int width,int height) {
		g.fillRect((int) (x), (int) (y),width,height);
	}
	public static void drawStaticRect(float x,float y,int width,int height,Color color) {
		g.setColor(color);
		g.fillRect((int) (x), (int) (y),width,height);
	}
	
	public static void drawStatictext(String text,int x,int y) {
		g.setColor(Color.white);
		g.drawString(text, x, y);
	}
	
	public static Game getGame() {
		return game;
	}
	public static void setGame(Game game) {
		Handler.game = game;
	}
	
	public static void drawStatictext_forMenu(Color color,String text,int x,int y){
		g.setColor(color);
		g.setFont(new Font("Arial",Font.BOLD,60));
		g.drawString(text, x, y);
	}
	
	public static MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	
}
