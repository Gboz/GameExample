package com.github.gboz.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.github.gboz.GameExample;
import com.github.gboz.entities.Player;
import com.github.gboz.ui.IClickCallback;
import com.github.gboz.ui.PlayerButton;

public class GameplayScreen extends AbstractScreen {

	private Player player;
	private PlayerButton playerButton;
	private Button resetScoreButton;
	private Label scoreLabel;

	public GameplayScreen(GameExample game) {
		super(game);
		init();
	}

	@Override
	protected void init() {
		initPlayer();
		initPlayerButton();
		initResetScoreButton();
		initScoreLabel();
	}

	private void initResetScoreButton() {
		resetScoreButton = new Button(new ButtonStyle());
		resetScoreButton.setWidth(100);
		resetScoreButton.setHeight(100);
		resetScoreButton.setX(330);
		resetScoreButton.setY(560);
		resetScoreButton.setDebug(true);

		stage.addActor(resetScoreButton);
		
		resetScoreButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				game.resetGameScore();

				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initScoreLabel() {
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = new BitmapFont();
		scoreLabel = new Label("", labelStyle);
		scoreLabel.setX(20);
		scoreLabel.setY(650);
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
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		scoreLabel.setText("Score: " + game.getPoints());
		stage.act();
	}

}
