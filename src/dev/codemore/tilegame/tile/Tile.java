package dev.codemore.tilegame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Tile {
	
	
	//Static stuff here
	
	public static Tile[] tiles = new Tile[256];	
	public static Tile limit = new LimitTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile rockTile = new RockTile(3);
	public static Tile waterTile = new WaterTile(4);
	//class
	
	public static final int TILEWIDTH = 128, TILEHEIGHT = 128;
	
	protected BufferedImage texture;
	protected final int id;
	private int xPos, yPos;
	
	public Tile(BufferedImage texture, int id, int x, int y) {
		this.texture = texture;
		this.id = id;
		this.xPos = x;
		this.yPos = y;
		
		tiles[id] = this;		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
					
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public boolean isSolid(){	
		return false;
	}
	public int getId() {
		return id;
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos(){
		return yPos; 	
	}
	public void setXPos(int x) {
		this.xPos = x;
	}
	public void setYPos(int y){
		this.yPos = y; 	
	}
}
