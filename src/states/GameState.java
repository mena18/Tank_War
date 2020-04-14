package states;

import java.awt.Graphics;

import entities.Player;
import gfx.Assets;
import tilegame.Game;
import tiles.Tile;
import worlds.World;

public class GameState extends State{

	private Player player;
	private World world;
	public GameState(Game game) {
		super(game);
		player = new Player(64,64,64,64,game);
		world = new World("res/map1.txt",game);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		player.render(g);
	}
	
	public World getWorld() {
		return world;
	}

}
