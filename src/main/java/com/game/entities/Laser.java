package com.game.entities;

import com.engine.abstracts.object.GameObject;

import java.awt.*;
import java.io.Serializable;

public class Laser extends GameObject implements Serializable {

    private float x, y, originalX, originalY;
    private Color color;

    public Laser() {
        super();
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

    public void setLocation(Point point) {
        originalX = point.x + 34;
        originalY = point.y + 18;
        x = originalX;
        y = originalY;
    }
}
