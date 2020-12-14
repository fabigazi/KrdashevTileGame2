package dev.codemore.tilegame.entities.statics;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
}
