package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;

import Cloud.Cloud;
import Player.Player;
import helpers.GameInfo;

/**
 * Created by Vladk on 21/07/2016.
 */
public class MainMenu implements Screen, ContactListener {

    private MyGdxGame game;
    private Texture bg;
    private Player player;
    private World world;
    private OrthographicCamera box2DCamera;
    private Box2DDebugRenderer debugRenderer;


    // constructor
    public MainMenu(MyGdxGame game) {
        this.game = game;

        box2DCamera = new OrthographicCamera();
        box2DCamera.setToOrtho(false, GameInfo.WIDTH / GameInfo.PPM,
                GameInfo.HEIGHT / GameInfo.PPM);
        box2DCamera.position.set(GameInfo.WIDTH / 2f,
                GameInfo.HEIGHT / 2f, 0);     // x,y,z as parameters

        debugRenderer = new Box2DDebugRenderer();

        world = new World(new Vector2(0, -9.8f), true);
        world.setContactListener(this);

        bg = new Texture("Game BG.png");
        player = new Player(world, "Player 1.png",
                GameInfo.WIDTH/2, GameInfo.HEIGHT/2 + 250    );

        // 1 pixels == 1 meter - by default for box2D

        Cloud c  = new Cloud(world);
    }

    void update(float dt) {
       if(Gdx.input.isKeyPressed(Keys.LEFT)) {
//            player.getBody().applyLinearImpulse(new Vector2(-0.1f,0),
//                    player.getBody().getWorldCenter(), true);

           // Force will move player over time
           player.getBody().applyForce(new Vector2(-5f, 0),
                   player.getBody().getWorldCenter(), true);
       } else  if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
//           player.getBody().applyLinearImpulse(new Vector2(0.1f,0),
//                   player.getBody().getWorldCenter(), true);

           player.getBody().applyForce(new Vector2(5f,0),
                   player.getBody().getWorldCenter(), true);
       }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);

        player.updatePlayer();

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0);
        game.getBatch().draw(player, player.getX(),
                player.getY() - player.getHeight()/2);
        game.getBatch().end();

        debugRenderer.render(world, box2DCamera.combined);      //  box2DCamera.combined return projection matrix

        // how many times per second world calculates physics
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg.dispose();
        player.getTexture().dispose();
    }

    @Override
    public void beginContact(Contact contact) {

        Fixture firstBody, secondBody;

        // Make wure that firstBody is a Player
        if(contact.getFixtureA().getUserData() == "Player" ) {
            firstBody = contact.getFixtureA();
            secondBody = contact.getFixtureB();
        } else {
            firstBody = contact.getFixtureB();
            secondBody = contact.getFixtureA();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
