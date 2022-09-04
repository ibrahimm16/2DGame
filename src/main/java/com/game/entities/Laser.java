package com.game.entities;

import com.game.util.GameObject;

import java.awt.*;

public class Laser extends GameObject {

    private float x, y, originalX, originalY;

    public Laser(float originalX, float originalY) {
        x = originalX;
        y = originalY;
        this.originalX = originalX;
        this.originalY = originalY;
    }

    @Override
    public void update() {
        if (x - originalX > 500) markedForRemoval = true;
        x += 2f;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.red);
        graphics2D.drawRect((int) x, (int) y, 10, 5);
    }
}
