package com.game.entities.player;

import com.engine.util.generics.SerializerUtil;
import com.game.entities.Starship;
import com.engine.abstracts.object.GameObject;
import com.engine.util.generics.ConversionUtil;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        objects.add(new Starship());
        timer.add("load", 200);
    }

    @Override
    public void update() {
        if (inputMap.get('1')) {
            Starship starship = ConversionUtil.getStarship(objects);
            SerializerUtil.saveStarship(starship);

        }

        if (inputMap.get('2')) {
            fireTimedEvent("load", () -> {
                Starship starship = SerializerUtil.loadStarship();
                objects.add(starship);
            });
        }
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
