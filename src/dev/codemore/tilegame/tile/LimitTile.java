package dev.codemore.tilegame.tile;

import dev.codemore.tilegame.gfx.Assets;

public class LimitTile extends Tile{
	
	public LimitTile(int id) {
		super(Assets.limit, id, 0, 0);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
