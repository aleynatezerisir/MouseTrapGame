package com.kas.mousetrap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Mouse {
    Vector2 position = new Vector2();
    TextureRegion picture;

    public Mouse (int x, int y){
        this.position.x = x;
        this.position.y = y;
        this.picture = new TextureRegion(new Texture("mouse.png"));
    }

}
