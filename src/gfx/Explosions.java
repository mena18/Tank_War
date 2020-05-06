package gfx;

import java.awt.image.BufferedImage;

import GameLib.Animations;
import GameLib.Music;

public class Explosions extends Animations {
	public Explosions (int x,int y){
		
		width=64;height=64;
		this.x=x-width/2;
		this.y=y-height/2;
		this.load();
	}
	
	public Explosions(int x,int y,int width,int height){
		this.x=x-width/2;
		this.y=y-height/2;
		this.width=width;
		this.height=height;
		this.load();
	}
	
	public void load() {
		images = new BufferedImage[5];
		images[0] = Assets.explosion1;
		images[1] = Assets.explosion2;
		images[2] = Assets.explosion3;
		images[3] = Assets.explosion4;
		images[4] = Assets.explosion5;
		i=0;
		length=5;
		new Music(Assets.shooting1).play();    
		
		this.start();
	}
}
