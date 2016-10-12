package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MarioBros;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MarioBros.V_WIDTH * 2;
		config.height = MarioBros.V_HEIGHT * 2;
		config.title = "Mario Bros";
		new LwjglApplication(new MarioBros(), config);
	}
}
