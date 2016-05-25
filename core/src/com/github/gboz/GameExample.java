package com.github.gboz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.gboz.screens.SplashScreen;

public class GameExample extends Game {

	public final static String GAME_NAME = "Game Example";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused;

	@Override
	public void create() {
		this.setScreen(new SplashScreen(this));
	}


	/**
	 * 
	 * getters and setters
	 */

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
