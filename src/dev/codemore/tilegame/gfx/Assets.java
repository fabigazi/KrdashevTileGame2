package dev.codemore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 50, height = 50;
	
	public static BufferedImage trashCity, town, coalPlant, solarPanels, city, limit; 
	
	public static BufferedImage tree, grass, dirt, stone, heart, water; 
	
	public static BufferedImage[] player_down, player_up, player_right, player_left;
	
	public static BufferedImage[] btn_start;
	

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet2.png"));
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 2, height * 3,width * 2, height);
		btn_start[1] = sheet.crop(0, height * 3, width * 2, height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		player_down[0] = sheet.crop(0, height * 2, 25, 25);
		player_down[1] = sheet.crop(0, height * 2, 25, 25);
		
		player_up[0] = sheet.crop(0, height * 2, 25, 25);
		player_up[1] = sheet.crop(0, height * 2, 25, 25);
		
		player_right[0] = sheet.crop(0, height * 2, 25, 25);
		player_right[1] = sheet.crop(0, height * 2, 25, 25);
		
		player_left[0] = sheet.crop(0, height * 2, 25, 25);
		player_left[1] = sheet.crop(0, height * 2, 25, 25);
		
		
		trashCity = sheet.crop(0, 0, width, height);
		town = sheet.crop(width, 0, width, height);
		coalPlant = sheet.crop(width*2, 0, width, height);
		solarPanels = sheet.crop(width*3, 0, width, height);
		city = sheet.crop(0, height, width, height);
		limit = sheet.crop(width*4, height*4, width, height);
		
		
		tree = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, height, width, height);
		dirt = sheet.crop(width * 2, height, width, height);
		stone = sheet.crop(width, height*2, width, height);
		heart = sheet.crop(0, 0, width, height);
		water = sheet.crop(width *2, height, width, height);
	}
}
