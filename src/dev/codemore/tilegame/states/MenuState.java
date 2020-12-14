package dev.codemore.tilegame.states;

import java.awt.Graphics;

import dev.codemore.tilegame.Handler;
import dev.codemore.tilegame.gfx.Assets;
import dev.codemore.tilegame.ui.ClickListener;
import dev.codemore.tilegame.ui.UIImageButton;
import dev.codemore.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200,200,128,64, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
			}}));
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}
