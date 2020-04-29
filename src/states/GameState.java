package states;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Bonus;
import entities.Bullets;
import entities.Enemy;
import entities.Player;
import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;
import tiles.Tile;
import worlds.World;
import GameLib.Animations;
import GameLib.Sprite;
import GameLib.SpriteGroup;
import GameLib.collisionAction;


class Tanks_bullets implements collisionAction{
	public void action(Sprite enemy,Sprite bullet) {
		new Explosions((int)bullet.getX(),(int)bullet.getY());
		((Bullets)bullet).get_player().inc_score(5);
		bullet.destroy();
		enemy.reduce_health(20,(Bullets)bullet);
	}
}

class Player_bonus implements collisionAction{
	public void action(Sprite player,Sprite bonus) {
		((Bonus)bonus).bonus_effect();
	}
}

class Player_enemy_action implements collisionAction{

	@Override
	public void action(Sprite player, Sprite enemy) {
		((Player)player).undo();
		((Enemy)enemy).undo();
		
	}
	
}

public class GameState extends State{

	private Player player;
	private World world;
	private collisionAction tanks_bullets,player_bonus,player_enemy_action;
	
	public  SpriteGroup Players,enemy_tanks,player_bullets,bonuses;
	
	
	public GameState(Game game) {
		super(game);
		enemy_tanks = new SpriteGroup();
		player_bullets = new SpriteGroup();
		bonuses = new SpriteGroup();
		Players = new SpriteGroup();
		
		world = new World("res/map1.txt",game);
		player = new Player(128,128,64,64,game);

	
		Players.add(player);
		enemy_tanks.add(new Enemy(300,300,50, 50, Assets.enemy1, game));
		enemy_tanks.add(new Enemy(500,500,50, 50, Assets.enemy1, game));
		bonuses.add(new Bonus(700, 500,30,30 ,game,player));
		
		tanks_bullets = new Tanks_bullets();
		player_bonus = new Player_bonus();
		player_enemy_action = new Player_enemy_action();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		Players.update();
		enemy_tanks.update();
		player_bullets.update();
		bonuses.update();
		Animations.update();
		
		// collision
		enemy_tanks.collisionGroup(player_bullets,tanks_bullets);
		Players.collisionGroup(bonuses, player_bonus);
		Players.collisionGroup(enemy_tanks, player_enemy_action);
		
		game.getGameCamera().centerOnEntity(player);
		
	
	}

	@Override
	public void render() {
		world.render();
		Players.draw();
		player_bullets.draw();
		enemy_tanks.draw();
		bonuses.draw();
		Animations.draw();
		

	}
	
	public World getWorld() {
		return world;
	}

}
