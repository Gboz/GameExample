package com.github.gboz.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.gboz.GameExample;
import com.github.gboz.entities.Player;
import com.github.gboz.ui.IClickCallback;
import com.github.gboz.ui.PlayerButton;
import com.github.gboz.ui.ResetScoreButton;
import com.github.gboz.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {

	private Texture bgTexture;
	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;

	public GameplayScreen(GameExample game) {
		super(game);
		init();
	}

	@Override
	protected void init() {
		bgTexture = new Texture("bg.png");
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}

	private void initResetScoreButton() {
		resetScoreButton = new ResetScoreButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.resetGameScore();

			}
		});

		stage.addActor(resetScoreButton);

	}

	private void initScoreLabel() {
		scoreLabel = new ScoreLabel();
		stage.addActor(scoreLabel);
	}

	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {

			@Override
			public void onClick() {
				// TODO Auto-generated method stub

			}
		});

		stage.addActor(playerButton);
		playerButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				player.reactOnClick();
				game.addPoint();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

	}

	private void initPlayer() {
		player = new Player();
		stage.addActor(player);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update();

		// for debug points
		// System.out.println("Points " + game.getPoints());

		spriteBatch.begin();
		spriteBatch.draw(bgTexture, 0, 0);
		spriteBatch.end();
	
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}

}
