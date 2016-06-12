package com.github.gboz.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.gboz.GameExample;
import com.github.gboz.entities.FlyingObject;
import com.github.gboz.entities.Player;
import com.github.gboz.ui.IClickCallback;
import com.github.gboz.ui.PlayerButton;
import com.github.gboz.ui.ResetScoreButton;
import com.github.gboz.ui.ScoreLabel;

public class GameplayScreen extends AbstractScreen {

	private Image bgImage;
	private Player player;
	private PlayerButton playerButton;
	private ResetScoreButton resetScoreButton;
	private ScoreLabel scoreLabel;
	private FlyingObject flyingObject1;

	public GameplayScreen(GameExample game) {
		super(game);
	}

	@Override
	protected void init() {
		initBG();
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
		initFlyingObjects();
	}

	private void initFlyingObjects() {
		flyingObject1 = new FlyingObject();
		stage.addActor(flyingObject1);
		flyingObject1.flyLikeHell();
	}

	private void initBG() {
		bgImage = new Image(new Texture("bg.png"));
		stage.addActor(bgImage);
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

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}

}
