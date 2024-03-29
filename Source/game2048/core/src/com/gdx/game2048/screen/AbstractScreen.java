package com.gdx.game2048.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gdx.game2048.manager.GameSetting;

public abstract class AbstractScreen extends Stage implements Screen {

    protected AbstractScreen() {
        super();
    }

    // Subclasses must load actors in this method
    public abstract void buildStage();

    @Override
    public void render(float delta) {
        // Clear screen
        if (GameSetting.getInstance().getDark()) {
            Gdx.gl.glClearColor(0 / 255f, 34 / 255f, 51 / 255f, 1);
        } else
            Gdx.gl.glClearColor(252 / 255f, 246 / 255f, 228 / 255f, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Calling to Stage methods
        super.act(delta);
        super.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}