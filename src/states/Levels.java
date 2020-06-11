package states;

import Factory.TankFactory;
import entities.Base;
import gfx.Assets;
import tilegame.Game;
import worlds.World;

public class Levels {
	
	public int current_level;
	public GameState gamestate;
	public Game game;
	public Levels(int current_level,Game game,GameState gamestate){
		this.current_level=current_level;
		this.game = game;
		this.gamestate = gamestate;
		System.out.println(this.game);
		System.out.println(this.gamestate);
		
	}
	
	
	public int  get_level() {
		return current_level;
	}
	
	public void start_current_level () {
		if(current_level==1) {level_1();}
		else if(current_level==2) {level_2();}
		else if(current_level==3) {level_3();}
		else {System.out.println("You finished the game");}
	}
	
	public void next_level() {
		current_level++;
		start_current_level();
	}
	
	public void clear_previus_level() {
		gamestate.bonuses.clear();
		gamestate.enemy_tanks.clear();
		gamestate.player_bullets.clear();
		gamestate.enemy_bullets.clear();
		gamestate.enemy_base.clear();
		gamestate.Player_base.clear();
	}
	
	public void level_1() {
		clear_previus_level();
		gamestate.world = new World("res/map1.txt",game);
		gamestate.enemy_base.add(new Base(50, 50, 100, 100, game, Assets.base2,new TankFactory(game, gamestate.enemy_tanks)));
		gamestate.base  = new Base(1250, 1250, 100, 100, game, Assets.base1);
		gamestate.Player_base.add(gamestate.base);
		gamestate.player.set_position(1200, 1200);
	}

	public void level_2() {
		clear_previus_level();
		gamestate.world = new World("res/map2.txt",game);
		gamestate.enemy_base.add(new Base(50, 50, 100, 100, game, Assets.base2,new TankFactory(game, gamestate.enemy_tanks)));
		gamestate.base  = new Base(3000, 3000, 100, 100, game, Assets.base1);
		gamestate.Player_base.add(gamestate.base);
		gamestate.player.set_position(3000, 3000);
	}

	public void level_3() {
		clear_previus_level();
		gamestate.world = new World("res/map3.txt",game);
		gamestate.enemy_base.add(new Base(50, 50, 100, 100, game, Assets.base2,new TankFactory(game, gamestate.enemy_tanks)));
		gamestate.base  = new Base(4300, 4300, 100, 100, game, Assets.base1);
		gamestate.Player_base.add(gamestate.base);
		gamestate.player.set_position(4250, 4250);
	}
}
