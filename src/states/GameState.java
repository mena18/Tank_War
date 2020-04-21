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
	public void action(Sprite a,Sprite b) {
		b.destroy();
		new Explosions((int)b.getX(),(int)b.getY());
		System.out.println("good job");
	}
}

public class GameState extends State{

	private Player player;
	private World world;
	private Tanks_bullets tanks_bullets;
	
	public  SpriteGroup enemy_tanks,player_bullets;

	
	public GameState(Game game) {
		super(game);
		enemy_tanks = new SpriteGroup();
		player_bullets = new SpriteGroup();
		world = new World("res/map1.txt",game);
		player = new Player(128,128,64,64,game);

	
		
		enemy_tanks.add(new Enemy(300,300,50, 50, Assets.enemy1, game));
		enemy_tanks.add(new Enemy(500,500,50, 50, Assets.enemy1, game));
		tanks_bullets = new Tanks_bullets();
		
	
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		player.update();
		enemy_tanks.update();
		player_bullets.update();
		enemy_tanks.collisionGroup(player_bullets,tanks_bullets);
		Animations.update();
		game.getGameCamera().centerOnEntity(player);
	
	}

	@Override
	public void render() {
		world.render();
		player.draw();
		player_bullets.draw();
		enemy_tanks.draw();
		Animations.draw();
		

	}
	
	public World getWorld() {
		return world;
	}

}
