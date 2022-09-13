package com.game.entities.player;

import com.game.entities.Starship;
import com.game.util.abstracts.GameObject;
import com.game.util.gameobject.ConversionUtil;
import com.game.util.gameobject.Converter;
import com.game.util.serialization.Serializer;

import java.awt.*;

public class Player extends GameObject {

    public Player() {
        objects.add(new Starship());
    }

    @Override
    public void update() {
        if (inputMap.get('1')) {
            Serializer.serializeStarship(ConversionUtil.getStarship(objects));
        }

        if (inputMap.get('2')) {
            fireTimedEvent(200, () -> {
                objects.add(Serializer.deserializeStarship());
                ticks = 0;
            });
        }
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
