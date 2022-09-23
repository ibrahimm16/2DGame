package com.game.entities;

import com.engine.abstracts.object.AbstractWeapon;
import com.engine.abstracts.object.Entity;

import java.awt.*;

public class Laser extends AbstractWeapon {


    public Laser() {
        super();
        maxSpeed = 2f;
        vector.range = 800;
        vector.velX = 2f;
        vector.velY = 0;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.drawRect((int) vector.x, (int) vector.y, 10, 5);
    }
}
