package com.game.entities;

import com.engine.abstracts.object.Weapon;

import java.awt.*;

public class Laser extends Weapon {

    private Color color;

    public Laser() {
        super();
        maxSpeed = 2f;
        vector.range = 800;
        width = Math.ceil(1);
        height = Math.ceil(1);
        vector.velX = 2f;
        vector.velY = 0;
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    //int centerX =

    @Override
    public void render(Graphics2D graphics2D) {
        rotate(graphics2D, 1);
        graphics2D.setColor(color);
        graphics2D.drawRect((int)(vector.x), (int)(vector.y), (int)width, (int)height);
        rotate(graphics2D, -1);
    }
}
