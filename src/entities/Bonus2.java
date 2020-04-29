package entities;

import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;
import GameLib.Sprite;

public class Bonus2 extends Sprite{
	
	Player player;
	public Bonus2(float x, float y, int width, int height, Game game,Player player) {
		super(x, y, width, height, game,Assets.shield);
		this.player=player;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void bonus_effect() {
		this.player.set_health(player.get_health()+10);
		this.player.inc_score(1000);
		this.destroy();
	}
	
	public void destroy() {
		game.getgamestate().bonuses.remove(this);
		
	}
	


}
