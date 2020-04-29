package tilegame;

import display.Display;
import gfx.Assets;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameLib.GameCamera;
import GameLib.ImageLoader;
import GameLib.KeyManager;
import GameLib.MouseManager;
import GameLib.SpriteSheet;

import java.awt.Color;
import java.awt.Font;
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
	private MouseManager mousemanager;
	private Graphics g;
	private GameCamera camera;
	
	/* states */
	private State gamestate;
	private State menustate;

	public Game(String title,int width,int height) {
		this.width=width;
		this.height=height;
		this.title=title;
		keymanager = new KeyManager();
		mousemanager = new MouseManager();
		
	}
	
	public GameState getgamestate() {
		return (GameState) gamestate;
	}
	
	public KeyManager getKeyManager() {
		return this.keymanager;
	}
	public MouseManager getMouseManager() {
		return this.mousemanager;
	}
	
	
	public GameCamera getGameCamera() {
		return camera;
	}
	
	private void init() {
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keymanager);
		display.getFrame().addMouseListener(mousemanager);
		display.getFrame().addMouseMotionListener(mousemanager);
		display.getCanvas().addMouseListener(mousemanager);
		display.getCanvas().addMouseMotionListener(mousemanager);
		Assets.init();
		
		camera = new GameCamera(this, 0,0);
		
		gamestate = new GameState(this);
		menustate = new MenuState(this);
		State.setState(gamestate);
		Handler.setGame(this);

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
		Handler.set_Graphics(g);
		g.clearRect(0, 0, width, height);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		/* start here */

		if(State.getState() != null)
			State.getState().render();
		
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
