package com.game.entities.player;

import com.engine.abstracts.object.Weapon;

import java.awt.*;

public class Missile extends Weapon {
    public float acceleration = .006f;


    public Missile() {
        super();
        maxSpeed = 2f;
        width = 25;
        height = 10;
        vector.range = 800;
        vector.velX = .1f;
        vector.velY = 0;
    }

    public void update() {
        vector.velX += (vector.velX > 0) ? acceleration : -1 * acceleration;
        super.update();
    }

    @Override
    public void render(Graphics2D graphics2D) {
        rotate(graphics2D, 1);
        graphics2D.drawImage(image, (int)vector.x, (int)vector.y, (int)width, (int)height, null);
        rotate(graphics2D, -1);
    }
}

