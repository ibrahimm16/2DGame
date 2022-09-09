package com.game.entities.player;

import com.game.entities.Starship;
import com.game.util.abstracts.GameObject;
import com.game.util.gameobject.Converter;

import java.awt.*;

public class Player extends GameObject {

    public static Converter<Player> util = new Converter<>();

    public Player() {
        objects.add(new Starship());
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
