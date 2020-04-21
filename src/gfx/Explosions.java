package gfx;

import java.awt.image.BufferedImage;

import GameLib.Animations;

public class Explosions extends Animations {
	public Explosions (int x,int y){
		this.x=x;
		this.y=y;
		width=64;height=64;
		images = new BufferedImage[5];
		images[0] = Assets.explosion1;
		images[1] = Assets.explosion2;
		images[2] = Assets.explosion3;
		images[3] = Assets.explosion4;
		images[4] = Assets.explosion5;
		i=0;
		length=5;
		this.start();
	}
}
