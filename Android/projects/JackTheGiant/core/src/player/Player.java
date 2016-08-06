package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import helpers.GameInfo;

/**
 * Created by Vladk on 06/08/2016.
 */
public class Player extends Sprite {

    private World world;
    private Body body;


    public Player(World world, float x, float y) {
        super(new Texture("Player/Player 1.png"));
        this.world = world;

        setPosition(x, y);
        createBody();

    }

    void createBody() {     // by default private
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set(getX() / GameInfo.PPM, getY() / GameInfo.PPM);

        body = world.createBody(bodyDef);
        body.setFixedRotation(true);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2f - 10) / GameInfo.PPM, (getHeight() / 2f) / GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 4f;        // mass of the body
        fixtureDef.friction = 2f;       // prevent sliding
        fixtureDef.shape = shape;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();


    }

    public void movePlayer(float x) {
        body.setLinearVelocity(x, body.getLinearVelocity().y);
    }

    public void  drawPlayer(SpriteBatch batch) {
        batch.draw(this, getX() + getWidth() / 2f, getY() - getHeight() / 2f);
    }

    public void updatePlayer() {
        setPosition(body.getPosition().x * GameInfo.PPM, body.getPosition().y * GameInfo.PPM);
    }

}
