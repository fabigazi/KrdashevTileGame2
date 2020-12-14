package dev.codemore.tilegame.building;

import dev.codemore.tilegame.gfx.Assets;

public class CityBuilding extends Building{

	
	public CityBuilding(int id) {
		
		super(Assets.city, id, "Town",
							new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0},  
							new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0});
		
	}
}
