package tilegame;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import gfx.ImageLoader;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import gfx.SpriteSheet;
import input.KeyManager;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;

import states.State;
import states.GameState;
import states.MenuState;

public class Game implements Runnable{
	private Display display;
	private Thread thread;
	public int width,height;
	String title;
	private boolean running;
	
	private BufferStrategy bs;
	private KeyManager keymanager;
	private Graphics g;
	private GameCamera camera;
	
	/* states */
	private State gamestate;
	State menustate;

	public Game(String title,int width,int height) {
		this.width=width;
		this.height=height;
		this.title=title;
		keymanager = new KeyManager();
		
	}
	
	public GameState getgamestate() {
		return (GameState) gamestate;
	}
	
	public KeyManager getKeyManager() {
		return this.keymanager;
	}
	
	public GameCamera getGameCamera() {
		return camera;
	}
	
	private void init() {
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keymanager);
		Assets.init();
		
		camera = new GameCamera(this, 0,0);
		
		gamestate = new GameState(this);
		menustate = new MenuState(this);
		State.setState(gamestate);

	}
	private void tick() {
		keymanager.tick();
		if(State.getState() != null)
			State.getState().tick();
		
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		/* start here */

		if(State.getState() != null)
			State.getState().render(g);
		
		/* End here */
		bs.show();
		g.dispose();
		
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	
	public void run() {
		init();
		
		int fps=100;
		double timePerTick = 1000000000 / fps;
		double now =System.nanoTime();
		double last=now;
		
//		double main_begin=now;
//		int counter=1;
		
		while(running) {
			last = System.nanoTime();
			
			if(last-now > timePerTick) {
//				counter++;
				now = last;
				tick();
				render();
			}
//			if(last - main_begin > 1000000000) {
//				System.out.println("one Second passed : "+(last-main_begin)+"  "+counter);
//				counter=1;
//				main_begin=last;
//			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if(running )
			return ;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!running)
			return ;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
