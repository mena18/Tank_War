package Factory;

import GameLib.SpriteGroup;
import entities.Enemy;
import tilegame.Game;

public class TankFactory extends Thread{
	
	Game game;
	SpriteGroup enemy_tanks;
	boolean tr;
	public TankFactory(Game game,SpriteGroup enemy_tanks) {
		this.game = game;
		this.enemy_tanks=enemy_tanks;
		this.tr=true;
	}
	
	public void run() {
		try {
			while(tr) {
				int p1 = (int)((Math.random()-0.5)*60);
				int p2 = (int)((Math.random()-0.5)*60);
				enemy_tanks.add(new Enemy(200+p1,200+p2,50, 50, game));
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		this.tr=false;
	}
}
