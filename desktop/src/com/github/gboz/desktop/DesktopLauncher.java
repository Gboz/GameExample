package com.github.gboz.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.gboz.GameExample;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = GameExample.GAME_NAME;
		config.width = GameExample.WIDTH;
		config.height = GameExample.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new GameExample(), config);
	}
}
