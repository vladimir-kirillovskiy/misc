package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class Platformer extends ApplicationAdapter {

	private SceneLoader sceneLoader;
	private Viewport viewport;
	private ItemWrapper root;
	private Player player;

	private UIStage uiStage;

	@Override
	public void create () {
		// translate pixels to world units, we using 3 pixels per WU
		viewport = new FitViewport(266, 160);

		sceneLoader = new SceneLoader();
		sceneLoader.loadScene("MainScene", viewport);

		player = new Player(sceneLoader.world);

		// get player animation
		ItemWrapper root = new ItemWrapper(sceneLoader.getRoot());
		root.getChild("player").addScript(player);

		uiStage = new UIStage(sceneLoader.getRm());

		sceneLoader.addComponentsByTagName("platform", PlatformComponent.class);

		sceneLoader.getEngine().addSystem(new PlatformSystem());

		/* moved it to UIStage class
		// doesn't work((
		// put button as an entity inside the scene
		sceneLoader.addComponentsByTagName("button", ButtonComponent.class);
		// a bit slower that component retrival
		// component retriver is better to use in render
		root.getChild("button").getEntity().getComponent(ButtonComponent.class).addListener(new ButtonComponent.ButtonListener() {
			@Override
			public void touchUp() {

			}

			@Override
			public void touchDown() {

			}

			@Override
			public void clicked() {
				System.out.println("Clicked");
			}
		});*/
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());

		uiStage.act();
		uiStage.draw();

		// follow player with camera
		viewport.getCamera().position.x = player.getX() + player.getWidth() / 2f;

	}
	
	@Override
	public void dispose () {

	}
}
