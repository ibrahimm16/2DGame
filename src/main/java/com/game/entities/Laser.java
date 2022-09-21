package com.game.entities;

import com.engine.abstracts.object.AbstractWeapon;
import com.engine.abstracts.object.Entity;

import java.awt.*;

public class Laser extends AbstractWeapon {


    public Laser() {
        super();
        range = 800;
        velX = 2f;
        velY = 0;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.drawRect((int) x, (int) y, 10, 5);
    }
}
