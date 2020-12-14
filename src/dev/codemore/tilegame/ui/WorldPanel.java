package dev.codemore.tilegame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codemore.tilegame.tile.Tile;

public class WorldPanel {
	private int width, height;
	
	public WorldPanel(int width, int height) {
		this.width = width;
		this.height = height;		
	}
	
	public void render(Graphics g, int x, int y, BufferedImage texture, BufferedImage building, int xPos, int yPos) {
		
		g.setColor(new Color(51, 204, 255, 127));
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.WHITE);
		g.drawString(x +","+ y, 20, 20);
		
		g.setColor(Color.WHITE);
		g.drawString(xPos +","+ yPos, 20, 40);
		
		g.drawImage(texture, 20, 70, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		if(building != null)
			g.drawImage(building, 20, 80 +Tile.TILEHEIGHT,  Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}

}
