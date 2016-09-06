package huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GameMain;

import helpers.GameInfo;
import helpers.GameManager;
import scenes.MainMenu;

/**
 * Created by Vladk on 12/08/2016.
 */
public class HighscoreButtons {

    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;

    private Label scoreLabel, coinLabel;
    private ImageButton backBtn;

    public HighscoreButtons(GameMain game) {
        this.game = game;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT, new OrthographicCamera());

        stage = new Stage(gameViewport, game.getBatch());
        Gdx.input.setInputProcessor(stage);

        createAndPositionUIElements();

        stage.addActor(backBtn);
        stage.addActor(scoreLabel);
        stage.addActor(coinLabel);
    }

    void createAndPositionUIElements() {
        backBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/2 - Options Buttons/Back.png"))));


        // load font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Fonts/blow.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;

        // create 2 fonts, can use one
        BitmapFont scoreFont = generator.generateFont(parameter);
        BitmapFont coinFont = generator.generateFont(parameter);

        // create lable with a font as a parameter
        scoreLabel = new Label(String.valueOf(GameManager.getInstance().gameData.getHighScore()),
                new Label.LabelStyle(scoreFont, Color.WHITE));
        coinLabel = new Label(String.valueOf(GameManager.getInstance().gameData.getCoinHighScore()),
                new Label.LabelStyle(coinFont, Color.WHITE));


        // set position
        backBtn.setPosition(17, 17, Align.bottomLeft);

        backBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        scoreLabel.setPosition(GameInfo.WIDTH / 2f - 40, GameInfo.HEIGHT / 2f - 120);
        coinLabel.setPosition(GameInfo.WIDTH / 2f -40, GameInfo.HEIGHT / 2f - 215);


    }

    public Stage getStage() {
        return this.stage;
    }



}
