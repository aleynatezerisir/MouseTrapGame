package com.kas.mousetrap.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuScreen implements Screen {

    private Stage stage;
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private TextButton buttonPlay,buttonExit;
    private BitmapFont white,black;
    private Label heading;

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        atlas = new TextureAtlas("ui/atlas.pack");
        skin = new Skin(atlas);
        table = new Table(skin);
        white = new BitmapFont(Gdx.files.internal("font/white64.fnt"),false);
        black = new BitmapFont(Gdx.files.internal("font/black64.fnt"),false);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button.up");
        textButtonStyle.down = skin.getDrawable("button.down");
        textButtonStyle.font = black;
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;

        buttonExit = new TextButton("EXIT",textButtonStyle);
        buttonExit.pad(20);
        buttonExit.setPosition(0,0);
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x,float y){
                System.out.println("clicked");
            }
        });

        Label.LabelStyle headingStyle = new Label.LabelStyle(white, Color.WHITE);
        heading = new Label("Blackpoint 2",headingStyle);

        table.add(heading);
        table.row();
        table.add(buttonExit);
        table.debug();
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(buttonExit);
        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        stage.draw();

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
