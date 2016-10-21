package com.mygdx.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.physics.PhysicsBodyLoader;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Vladk on 2016-10-20.
 */
public class Player implements IScript {

    private Entity player;
    private TransformComponent transformComponent;
    private DimensionsComponent dimensionsComponent;

    private World world;

    private Vector2 speed;
    private float gravity = -500;

    private final float JUMP_SPEED = 200f;

    public Player(World world) {
        this.world = world;
    }

    @Override
    public void init(Entity entity) {
        player = entity;

        speed = new Vector2(100, 0);
        // x and y
        transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        // width and height
        dimensionsComponent = ComponentRetriever.get(entity, DimensionsComponent.class);

    }

    @Override
    public void act(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            transformComponent.x -= speed.x * delta;
            transformComponent.scaleX = -1f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            transformComponent.x += speed.x * delta;
            transformComponent.scaleX = 1f;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            speed.y = JUMP_SPEED;
        }

        speed.y += gravity * delta;
        transformComponent.y += speed.y * delta;

        // temp solution not to let it fall
       /* if (transformComponent.y < 7) {
            speed.y = 0;
            transformComponent.y = 7;
        }*/


        rayCast();

    }

    private void rayCast(){
        float rayGap = dimensionsComponent.height / 2f;
        float raySize = -(speed.y + Gdx.graphics.getDeltaTime()) * Gdx.graphics.getDeltaTime();
//        if(raySize < 5f) raySize = 5f;

        // only check for collision then moving down
        if(speed.y > 0) return;

        Vector2 rayFrom = new Vector2((transformComponent.x - dimensionsComponent.width / 2) * PhysicsBodyLoader.getScale(), (transformComponent.y + rayGap) * PhysicsBodyLoader.getScale());
        Vector2 rayTo = new Vector2((transformComponent.x - dimensionsComponent.width / 2) * PhysicsBodyLoader.getScale(), (transformComponent.y - raySize) * PhysicsBodyLoader.getScale());

        // cast the ray
        world.rayCast(new RayCastCallback() {
            @Override
            public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) {
                // stop the player
                speed.y = 0;

                // reposition player slightly upper the collision point
                transformComponent.y = point.y / PhysicsBodyLoader.getScale() + 0.01f;

                return 0;
            }
        }, rayFrom, rayTo);
    }

    public float getX() {
        return transformComponent.x;
    }

    public float getY() {
        return transformComponent.y;
    }

    public float getWidth() {
        return dimensionsComponent.width;
    }

    @Override
    public void dispose() {

    }
}
