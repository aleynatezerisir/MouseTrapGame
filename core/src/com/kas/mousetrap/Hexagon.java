package com.kas.mousetrap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Hexagon {
    Vector2 position = new Vector2();
    Vector2 MousePosition = new Vector2();
    Vector2 touchPosition1 = new Vector2();
    Vector2 touchPosition2 = new Vector2();

    Vector3 HexagonIndex = new Vector3();
    Texture picture;
    Texture hexagonchoosed = new Texture("hexagon_choosed.png");
    Texture hexagonpic = new Texture("hexagon.png");
    Texture hexagonbrickpic = new Texture("hexagon_brick.png");
    boolean brick;
    boolean choosed;
    int east,west,northeast,northwest,southwest,southeast;
    int hex_id;

    public Hexagon(int hex_id,int x,int y, boolean brick,boolean choosed,int east,int west,int northeast, int northwest,int southwest,int southeast){
        this.position.x = (float) x;
        this.position.y = (float) y;
        this.hex_id = hex_id;
        this.brick = brick;
        this.choosed=choosed;
        if(choosed)
            this.picture = hexagonchoosed;
        else
            this.picture = brick ? hexagonbrickpic : hexagonpic;

        this.east = east;
        this.west = west;
        this.northeast = northeast;
        this.northwest = northwest;
        this.southwest =southwest;
        this.southeast = southeast;

        this.MousePosition.x = (float)x+35;
        this.MousePosition.y = (float)y+23;

    }

    public Hexagon(int x1, int x2, int y1, int y2){
        this.touchPosition1.x = x1;
        this.touchPosition1.y = y1;
        this.touchPosition2.x = x2;
        this.touchPosition2.y = y2;
    }
}
