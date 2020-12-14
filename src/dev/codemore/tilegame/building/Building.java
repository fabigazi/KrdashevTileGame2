package dev.codemore.tilegame.building;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.tile.Tile;

public class Building {
	
	public static Building[] buildings = new Building[256];
	public static Building empty = null;
	public static Building town = new TownBuilding(1);
	public static Building City = new CityBuilding(2);
	
	private String name;
	private int[] initCost;
	private int[] turnCost;	
	protected BufferedImage texture;
	protected final int id;
	
	public Building(BufferedImage texture, int id, String name, int[] initCost, int[] turnCost) {
		this.texture = texture;
		this.id = id;
		this.name = name;
		this.initCost = initCost;
		this.turnCost = turnCost;
		
		buildings[id] = this;
	}
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Tile.TILEWIDTH,Tile.TILEHEIGHT, null);
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getInitCost() {
		return initCost;
	}
	
	public int[] getTurnCost() {
		return turnCost;
	}
	

}
