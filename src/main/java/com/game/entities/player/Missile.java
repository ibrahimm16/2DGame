package com.game.entities.player;

import com.engine.abstracts.object.AbstractWeapon;

import java.awt.*;

public class Missile extends AbstractWeapon {
    public float acceleration = .006f;


    public Missile() {
        super();
        maxSpeed = 2f;
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
        graphics2D.drawImage(image, (int)vector.x, (int)vector.y, null);
    }
}

