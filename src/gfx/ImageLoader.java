package gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	private BufferedImage image;
	
	public static BufferedImage loadImage(String name) {
		String path= "res/"+name;
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
}
