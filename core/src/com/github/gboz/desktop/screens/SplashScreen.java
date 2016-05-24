package com.github.gboz.desktop.screens;

import com.badlogic.gdx.graphics.Texture;
import com.github.gboz.GameExample;

public class SplashScreen extends AbstractScreem {

	private Texture splashImg;

	public SplashScreen(GameExample game) {
		super(game);
		init();

	}

	private void init() {
		//TODO implement better assets loading when game grows
		splashImg = new Texture("ct.jpg");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(splashImg, 0, 0);
		spriteBatch.end();
	}

}
