package com.game.entities;

import com.engine.abstracts.object.Entity;

import java.awt.*;

public class Laser extends Entity {

    private float originalX, originalY;
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

    public void setLocation(Rectangle boundingBox) {
        originalX = boundingBox.x + 34;
        originalY = boundingBox.y + 18;
        x = originalX;
        y = originalY;
    }
}
