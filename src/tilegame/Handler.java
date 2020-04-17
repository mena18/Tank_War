package tilegame;

import java.awt.Graphics;

public class Handler {
	
	
	private static Graphics g;
	public static void init() {
		
	}
	
	public static void set_Graphics(Graphics g) {
		Handler.g = g;
	}
	
	public static Graphics getGraphics() {
		return g;
	}
}
