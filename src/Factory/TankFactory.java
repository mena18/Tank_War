package Factory;

import GameLib.SpriteGroup;
import entities.Enemy;
import gfx.Assets;
import tilegame.Game;

public class TankFactory extends Thread{
	
	Game game;
	SpriteGroup enemy_tanks;
	boolean tr;
	int lev;
	public TankFactory(Game game,SpriteGroup enemy_tanks,int lev) {
		this.game = game;
		this.enemy_tanks=enemy_tanks;
		this.tr=true;
		this.lev=lev;
	}
	
	public void run() {
		try {
			while(tr) {
				int p1 = (int)((Math.random()-0.5)*60);
				int p2 = (int)((Math.random()-0.5)*60);
				if(lev==1) {
					enemy_tanks.add(new Enemy(200+p1,200+p2,50, 50, game,2,2,500,Assets.enemy1_body,Assets.enemy1_canon));
				}else if(lev==2) {
					enemy_tanks.add(new Enemy(200+p1,200+p2,50, 50, game,3,3,600,Assets.enemy2_body,Assets.enemy2_canon));
				}else {
					enemy_tanks.add(new Enemy(200+p1,200+p2,50, 50, game,4,4,700,Assets.enemy3_body,Assets.enemy3_canon));
				}
				
				Thread.sleep(4000);
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
