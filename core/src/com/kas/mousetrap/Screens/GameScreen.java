package com.kas.mousetrap.Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.kas.mousetrap.MouseTrap;

import javax.management.monitor.MonitorSettingException;

public class GameScreen extends ApplicationAdapter implements Screen {

    private MouseTrap game;

    @Override
    public void show() {
        game = new MouseTrap();
        game.create();
        game.render();

    }

    @Override
    public void render(float delta) {
        game = new MouseTrap();

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

    }
}
