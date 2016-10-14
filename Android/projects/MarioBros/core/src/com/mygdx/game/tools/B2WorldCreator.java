package com.mygdx.game.tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MarioBros;
import com.mygdx.game.screens.PlayScreen;
import com.mygdx.game.sprites.Brick;
import com.mygdx.game.sprites.Coin;
import com.mygdx.game.sprites.Goomba;

/**
 * Created by Vladk on 11/10/2016.
 */
public class B2WorldCreator {
    private Array<Goomba> goombas;

    public B2WorldCreator(PlayScreen screen) {

        World world = screen.getWorld();
        TiledMap map = screen.getMap();

        BodyDef bodyDef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fixtureDef = new FixtureDef();
        Body body;

        // create ground bodies/fixtures
        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);
            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() / 2) / MarioBros.PPM, (rect.getHeight() / 2) / MarioBros.PPM);
            fixtureDef.shape = shape;
            body.createFixture(fixtureDef);
        }

        // create pipe bodies/fixtures
        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bodyDef.type = BodyDef.BodyType.StaticBody;
            bodyDef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);
            body = world.createBody(bodyDef);

            shape.setAsBox((rect.getWidth() / 2) / MarioBros.PPM, (rect.getHeight() / 2) / MarioBros.PPM);
            fixtureDef.shape = shape;
            fixtureDef.filter.categoryBits = MarioBros.OBJECT_BIT;

            body.createFixture(fixtureDef);
        }

        // create brick bodies/fixtures
        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

           new Brick(screen, rect);
        }

        // create coin bodies/fixtures
        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

           new Coin(screen, rect);
        }

        // create coin bodies/fixtures
        goombas = new Array<Goomba>();

        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)) {
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }


    }

    public Array<Goomba> getGoombas() {
        return goombas;
    }
}
