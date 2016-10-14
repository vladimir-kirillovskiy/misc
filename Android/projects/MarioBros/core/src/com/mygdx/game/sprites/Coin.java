package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MarioBros;
import com.mygdx.game.scenes.Hud;
import com.mygdx.game.screens.PlayScreen;

/**
 * Created by Vladk on 11/10/2016.
 */
public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28; // tile id 27 + 1, as cout goes from 1

    public Coin(PlayScreen screen, Rectangle bounds) {
        super(screen, bounds);
        tileSet= map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
        if(getCell().getTile().getId() == BLANK_COIN) {
            MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
        } else {
            MarioBros.manager.get("audio/sounds/coin.wav", Sound.class).play();
        }
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        Hud.addScore(100);

    }
}
