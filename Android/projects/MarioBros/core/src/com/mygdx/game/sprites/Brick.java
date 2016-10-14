package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MarioBros;
import com.mygdx.game.scenes.Hud;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Vladk on 11/10/2016.
 */
public class Brick extends InteractiveTileObject {
    public Brick(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick", "Collision");
        setCategoryFilter(MarioBros.DESTROYED_BIT);

        getCell().setTile(null);
        Hud.addScore(200);
        MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();

    }
}
