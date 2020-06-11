package entities;

import gfx.Assets;
import tilegame.Game;
import tilegame.Handler;

import java.awt.image.BufferedImage;

import GameLib.Sprite;

public class ScoreBonus extends Bonus{
	
	public ScoreBonus(float x, float y, int width, int height, Game game,Player player) {
		super(x, y, width, height, game,player,Assets.money);
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void bonus_effect() {
		this.player.inc_score(1000);
		this.destroy();
	}
	
	public void destroy() {
		game.getgamestate().bonuses.remove(this);
	}
	


}
