package com.github.gboz.desktop.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.github.gboz.GameExample;

public class SplashScreen extends AbstractScreen {

	private Texture splashImg;

	public SplashScreen(final GameExample game) {
		super(game);
		init();
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				game.setScreen(new GameplayScreen(game));
			}
		}, 3);
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
