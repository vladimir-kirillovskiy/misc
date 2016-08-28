package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GameMain;

import helpers.GameInfo;
import scenes.MainMenu;

/**
 * Created by Vladk on 14/08/2016.
 */
public class OptionsButtons {

    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;

    private ImageButton easy, medium, hard, backBtn;
    private Image sign;

    public OptionsButtons(GameMain game) {
        this.game = game;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());

        stage = new Stage(gameViewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);
        createAndPossitionButtons();
        addAllListeners();

        stage.addActor(easy);
        stage.addActor(medium);
        stage.addActor(hard);
        stage.addActor(backBtn);
        stage.addActor(sign);
    }

    void createAndPossitionButtons() {
        easy = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/2 - Options Buttons/Easy.png"))));
        medium = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/2 - Options Buttons/Medium.png"))));
        hard = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/2 - Options Buttons/Hard.png"))));

        backBtn = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/2 - Options Buttons/Back.png"))));

//        sign = new Image(new SpriteDrawable(new Sprite(new Texture("Buttons/2 - Options Buttons/Check Sign.png"))));
//          or
        sign = new Image(new Texture("Buttons/2 - Options Buttons/Check Sign.png"));


        easy.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f + 40, Align.center);
        medium.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - 40, Align.center);
        hard.setPosition(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f - 120, Align.center);

        // remove this later
        sign.setPosition(GameInfo.WIDTH / 2f + 76, medium.getY() + 13, Align.bottomLeft);

    }

    void addAllListeners() {
        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        easy.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sign.setY(easy.getY() + 13);
            }
        });

        medium.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sign.setY(medium.getY() + 13);
            }
        });

        hard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sign.setY(hard.getY() + 13);
            }
        });
    }


    public Stage getStage() {
        return this.stage;
    }

}
