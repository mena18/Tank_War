package Factory;

import GameLib.SpriteGroup;
import entities.Bonus;
import entities.ScoreBonus;
import entities.HealthBonus;
import tilegame.Game;

public class BonusFactory {
	
	SpriteGroup bonus;
	Game game;
	public BonusFactory (SpriteGroup bonus,Game game) {
		this.bonus = bonus;
		this.game = game;
	}
	
	public void create_bonus(float x,float y) {
		System.out.println("inside bonus factory");
		int n = (int)(Math.random()*2);
		if(n==0) {
			 new HealthBonus(x, y, 30, 30, game, game.getgamestate().player);
		}else {
			 new ScoreBonus(x, y, 30, 30, game, game.getgamestate().player);
		}
		System.out.println("inside bonus factory");
	}
}
