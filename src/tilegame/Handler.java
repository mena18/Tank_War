package tilegame;

import java.awt.Graphics;

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
	
	public static Game getGame() {
		return game;
	}
	public static void setGame(Game game) {
		Handler.game = game;
	}
}
