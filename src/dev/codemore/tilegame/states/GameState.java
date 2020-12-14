package dev.codemore.tilegame.states;

import java.awt.Graphics;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.worlds.World;

public class GameState extends State{
	
	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/world/world1.txt");
		handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		world.tick();		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

	
}
