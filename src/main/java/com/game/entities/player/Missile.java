package com.game.entities.player;

import com.engine.abstracts.object.AbstractWeapon;

import java.awt.*;

public class Missile extends AbstractWeapon {
    public float acceleration = .006f;


    public Missile() {
        super();
        range = 800;
        velX = .1f;
        velY = 0;
    }

    public void update() {
        velX += acceleration;
        super.update();
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(image, (int)x, (int)y, 20, 10, null);
    }
}

