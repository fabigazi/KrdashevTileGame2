package dev.codemore.tilegame.building;

import dev.codemore.tilegame.gfx.Assets;

public class TownBuilding extends Building {
	
	public TownBuilding(int id) {
		
		super(Assets.town, id, "Town",
							new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0},  
							new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0});
		
	}

}
