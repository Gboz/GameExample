package com.github.gboz;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.github.gboz.screens.SplashScreen;

public class GameExample extends Game {

	public final static String GAME_PREFS = "com.github.gboz.prefs";
	public final static String GAME_SCORE = "com.github.gboz.prefs.score";
	public final static String GAME_NAME = "Game Example";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused;

	private int points;

	private Preferences prefs;

	public int getPoints() {
		return points;
	}

	public void addPoint() {
		points++;
		updateSavedScoreInPrefs();
	}

	public void addPoints(int pointsToAdd) {
		points += pointsToAdd;
		updateSavedScoreInPrefs();
	}

	private void updateSavedScoreInPrefs() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	@Override
	public void create() {
		init();
		this.setScreen(new SplashScreen(this));
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		loadScore();

	}

	private void loadScore() {
		points = prefs.getInteger(GAME_SCORE);

	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public void resetGameScore() {
		points = 0;
		updateSavedScoreInPrefs();
	}

	public void addPassiveIncome() {
		// TODO implement
		System.out.println("passive income debug");

	}
}
