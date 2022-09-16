package com.game.entities.player;

import com.engine.util.generics.ConversionUtil;
import com.engine.util.generics.SerializerUtil;
import com.game.entities.Starship;
import com.engine.abstracts.object.GameObject;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        super();
        Starship starship = SerializerUtil.loadStarship();
        objects.add(starship);
    }

    @Override
    public void update() {
        if (inputMap.get('1')) {
            Starship starship = ConversionUtil.getStarship(objects);
            SerializerUtil.saveStarship(starship);
        }

        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
