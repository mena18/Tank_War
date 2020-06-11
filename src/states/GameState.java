package states;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Factory.BonusFactory;
import Factory.TankFactory;
import entities.HealthBonus;
import entities.ScoreBonus;
import entities.PlayerBullets;
import entities.Enemy;
import entities.Player;
import gfx.Assets;
import gfx.Explosions;
import tilegame.Game;
import tiles.Tile;
import worlds.World;
import GameLib.Animations;
import GameLib.Music;
import GameLib.Sprite;
import GameLib.SpriteGroup;
import GameLib.collisionAction;
import entities.Base;
import entities.Bonus;


public class GameState extends State{

	public Player player;
	public Base base;
	
	public World world;
	public Levels level;
	public  SpriteGroup Players,enemy_tanks,player_bullets,bonuses,enemy_bullets,Player_base,enemy_base;
	public BonusFactory bonus_factory;
	
	public GameState(Game game) {
		super(game);
		
		bonuses = new SpriteGroup();
		
		player = new Player(128,128,64,64,game);
		Players = new SpriteGroup();
		Players.add(player);
		bonus_factory = new BonusFactory(bonuses,game);
		

		enemy_tanks = new SpriteGroup();
		player_bullets = new SpriteGroup();
		enemy_bullets = new SpriteGroup();
		
		Player_base = new SpriteGroup();
		enemy_base = new SpriteGroup();

		level = new Levels(1, game,this);
		level.start_current_level();

		

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		Players.update();
		enemy_tanks.update();
		player_bullets.update();
		enemy_bullets.update();
		bonuses.update();
		Player_base.update();
		enemy_base.update();
		Animations.update();
		
		
		// collision
		enemy_tanks.collisionGroup(player_bullets,new collisionAction() {
			public void action(Sprite enemy,Sprite bullet) {
				new Explosions((int)bullet.getX(),(int)bullet.getY());
				((PlayerBullets)bullet).get_player().inc_score(5);
				bullet.destroy();
				((Enemy)enemy).reduce_health(20);
				((PlayerBullets)bullet).get_player().inc_score(25);
			}
		});
		
		Players.collisionGroup(bonuses, new collisionAction() {
			public void action(Sprite player,Sprite bonus) {
				((Bonus)bonus).bonus_effect();
			}
		});
		
		Players.collisionGroup(enemy_tanks, new collisionAction() {
			public void action(Sprite player, Sprite enemy) {
				((Player)player).undo();
				((Enemy)enemy).undo();
				
			}
		});
		
		Players.collisionGroup(enemy_bullets, new collisionAction() {
			public void action(Sprite player, Sprite bullet) {
				System.out.println("collision between enemy_bullets and player");
				new Explosions((int)bullet.getX(),(int)bullet.getY());
				bullet.destroy();
				System.out.println(((Player)player).get_health());
				((Player)player).reduce_health(20);
				
			}
		});
		
		enemy_base.collisionGroup(player_bullets,new collisionAction() {
			public void action(Sprite base,Sprite bullet) {
				new Explosions((int)bullet.getX(),(int)bullet.getY());
				((PlayerBullets)bullet).get_player().inc_score(25);
				bullet.destroy();
				((Base)base).reduce_health();
			}
		});
		
		Player_base.collisionGroup(enemy_bullets,new collisionAction() {
			public void action(Sprite base,Sprite bullet) {
				new Explosions((int)bullet.getX(),(int)bullet.getY());
				bullet.destroy();
				((Base)base).reduce_health();
			}
		});
		
		
		
		
		
		
		
		game.getGameCamera().centerOnEntity(player);
		
		
		if(enemy_base.size()==0 && enemy_tanks.size()==0) {
			level.next_level();
		}
	
	}

	@Override
	public void render() {
		world.render();
		Players.draw();
		player_bullets.draw();
		enemy_tanks.draw();
		bonuses.draw();
		enemy_bullets.draw();
		Player_base.draw();
		enemy_base.draw();
		Animations.draw();
		

	}
	
	public World getWorld() {
		return world;
	}

}
