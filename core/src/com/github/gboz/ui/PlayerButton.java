package com.github.gboz.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PlayerButton extends Button {

	public PlayerButton(final IClickCallback callback) {
		super(new ButtonStyle());

		init(callback);

	}

	private void init(final IClickCallback callback) {
		this.setWidth(460);
		this.setHeight(360);
		this.setX(10);
		this.setY(170);
		//debug daje nam niebiesk¹ os³onkê na pole przycisku
//		this.setDebug(true);
		
		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				
				callback.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		

	}

}
