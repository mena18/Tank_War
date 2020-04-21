package GameLib;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import tilegame.Handler;

public class Animations {
	
	public static ArrayList<Animations> animations = new ArrayList<Animations>();
	
	
	public BufferedImage images[];
	
	public int length;
	public float i;
	public int x,y,width,height;
	
	
	
	
	public void start() {
		animations.add(this);
	}
	
	public static void update () {
		for(int j=0;j<animations.size();j++) {
			animations.get(j).i+=0.1;
			if(animations.get(j).i>=animations.get(j).length) {animations.remove(j);}
		}
		
		
	}
	
	public static void draw() {
		for(int j=0;j<animations.size();j++) {
			Handler.getGraphics().drawImage(animations.get(j).images[(int)animations.get(j).i], (int) (animations.get(j).x - Handler.getGame().getGameCamera().getxOffset()), (int) (animations.get(j).y - Handler.getGame().getGameCamera().getyOffset()), animations.get(j).width, animations.get(j).height, null);
		}
		
	}
	
	
}



