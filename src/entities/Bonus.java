package entities;

import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;
import GameLib.Sprite;

public class Bonus extends Sprite{
	
	Player player;
	public Bonus(float x, float y, int width, int height, Game game,Player player) {
		super(x, y, width, height, game,0);
		Image = Assets.shield;
		this.player=player;
		last_dir=0;
		this.sprite_images[0] = Image;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void bonus_effect() {
		this.player.set_health(player.get_health()+30);
		this.destroy();
	}
	
	public void destroy() {
		game.getgamestate().bonuses.remove(this);
	}
	


}
