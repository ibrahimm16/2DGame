package com.game.entities;

import com.game.util.abstracts.GameObject;

import java.awt.*;

public class Laser extends GameObject {

    private float x, y, originalX, originalY;
    private Color color;

    public Laser(float originalX, float originalY) {
        x = originalX;
        y = originalY;
        this.originalX = originalX;
        this.originalY = originalY;
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    @Override
    public void update() {
        if (x - originalX > 800) removable = true;
        x += 2f;
        super.update();
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.drawRect((int) x, (int) y, 10, 5);
    }

    @Override
    public String toString() {
        return "Laser{" +
                "x=" + x +
                ", y=" + y +
                ", originalX=" + originalX +
                ", originalY=" + originalY +
                '}';
    }
}
