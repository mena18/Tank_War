package tilegame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import display.Display;

public class Launcher {
	public static void main(String [] args) {
		Game game = new Game("hello",960,720);
		game.start();
		
	}
}
