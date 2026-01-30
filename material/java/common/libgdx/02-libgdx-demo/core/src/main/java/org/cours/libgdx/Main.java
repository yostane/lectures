package org.cours.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

enum GameScreen {
    MAIN_MENU,
    GAMEPLAY,
    GAME_OVER
}

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;

    private float imagePosX = 140;
    private float imagePosY = 210;
    private GameScreen currentGameScreen = GameScreen.MAIN_MENU;
    BitmapFont mainFont;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        mainFont = new BitmapFont(Gdx.files.internal("ui/font.fnt"));

    }

    @Override
    public void render() {
        // etat du jeu
        switch (currentGameScreen) {
            case MAIN_MENU:
                if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                    currentGameScreen = GameScreen.GAMEPLAY;
                }
                break;
            case GAMEPLAY:
                imagePosX += 0.1;
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                    imagePosY += 0.5;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                    imagePosY -= 0.5;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.X)) {
                    currentGameScreen = GameScreen.GAME_OVER;
                }
                break;
            case GAME_OVER:
                break;
        }

        // Rendu
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        switch (currentGameScreen) {
            case MAIN_MENU:
                mainFont.draw(batch, "Press 'S' to start", 140, 210);
                break;
            case GAMEPLAY:
                batch.draw(image, imagePosX, imagePosY);
                break;
            case GAME_OVER:
                mainFont.draw(batch, "GAME OVER", 140, 210);
                break;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
