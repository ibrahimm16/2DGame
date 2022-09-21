package com.engine.abstracts.object;

import java.awt.*;
import java.io.Serializable;

public abstract class AbstractWeapon extends Entity {

    public float originalX, originalY;
    public Color color;
    public float range;
    public float distance = 0;



    public AbstractWeapon() {
        super();
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public void setLocation(Rectangle boundingBox) {
        originalX = boundingBox.x + boundingBox.width;
        originalY = boundingBox.y + boundingBox.height / 2f;
        x = originalX;
        y = originalY;
    }

    @Override
    public void move() {
        super.move();
        double xDist = Math.pow(x-originalX, 2);
        double yDist = Math.pow(y-originalY, 2);
        distance = (float)Math.sqrt(xDist + yDist);
        if (distance > range) removable = true;

    }
}
