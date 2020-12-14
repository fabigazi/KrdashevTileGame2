package dev.codemore.tilegame.worlds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.building.Building;
import dev.codemore.tilegame.entities.EntityManager;
import dev.codemore.tilegame.entities.creatrures.Player;
import dev.codemore.tilegame.tile.Tile;
import dev.codemore.tilegame.ui.WorldPanel;
import dev.codemore.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	

	private int spawnX, spawnY;
	private int[][] tiles;
	private int[][] buildings;
	private WorldPanel panel;
	private int xTile, yTile;
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		
		spawnX = 300;
		spawnY = 300;
		this.handler = handler;
		this.panel = new WorldPanel(200, 700);
		entityManager = new EntityManager(handler, new Player(handler, 700, 700));
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		loadWorld(path);
		
	
		
		
		
	}
	
	public void tick()
	{	
		entityManager.tick();
		
	}
	
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width + 2, (handler.getGameCamera().getxOffset() + handler.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height + 2, (handler.getGameCamera().getyOffset() + handler.getHeight())/ Tile.TILEHEIGHT + 1);
		
		
		for(int y = yStart; y < yEnd; y++) {			
			for(int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int ) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
				if((x * Tile.TILEWIDTH) < entityManager.getPlayer().getX()
				&& (x * Tile.TILEWIDTH + Tile.TILEWIDTH) > entityManager.getPlayer().getX()
				&& (y * Tile.TILEHEIGHT ) < entityManager.getPlayer().getY()
				&& (y * Tile.TILEHEIGHT + Tile.TILEHEIGHT ) > entityManager.getPlayer().getY()) {
					xTile = x;
					yTile = y;
				}			
				
			}
		}
		
		for(int y = yStart; y < yEnd; y++) {			
			for(int x = xStart; x < xEnd; x++) {
				if(getBuilding(x,y) != null) {

					getBuilding(x,y).render(g, 
							(int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
							(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));	
				}
			}
		}
		
		
		
		//Entities
		entityManager.render(g);
		
		panel.render(g, 
					(int) entityManager.getPlayer().getX(), 
					(int) entityManager.getPlayer().getY(),
					getTile(xTile,yTile).getTexture(), 
					hasBuilding(xTile, yTile),
					xTile,
					yTile);
	}
	
	public BufferedImage hasBuilding(int x, int y) {
		if(getBuilding(xTile,yTile) == null)
			return getTile(xTile,yTile).getTexture();
		return getBuilding(xTile,yTile).getTexture();
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width + 2 || y >= height + 2) {
			Tile aTile = Tile.grassTile;
			aTile.setXPos(x);
			aTile.setYPos(y);
			return aTile;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		t.setXPos(x);
		t.setYPos(y);
		if(t == null) 
			return Tile.dirtTile;
		return t;
		
	}
	
	public Building getBuilding(int x, int y) {
		if(x < 0 || y < 0 || x >= width + 2 || y >= height + 2) {
			return null;
		}
		Building t = Building.buildings[buildings[x][y]];
		if(t == null) 
			return null;
		return t;
		
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		
		tiles = new int[width + 2][height + 2];

		for(int y = 1; y < height + 1; y++) {
			for(int x = 1; x < width + 1; x++) {
				tiles[x][y] = Utils.parseInt(tokens[((x - 1) + (y - 1) * width) + 4]);
			}
		}
		
		buildings = new int[width + 2][height + 2];
		
		for(int y = 1; y < height + 1; y++) {
			for(int x = 1; x < width + 1; x++) {
				buildings[x][y] = Utils.parseInt(tokens[(height * width + (x - 1) + ( y - 1) * width) + 5]);
			}
		}

	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth() {
		return width + 2;
	}
	
	public int getHeight() {
		return height + 2;
	}
}
