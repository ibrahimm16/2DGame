package com.engine.abstracts.object;

import java.awt.*;
import java.io.Serializable;

public abstract class AbstractWeapon extends Entity {


    public Color color;
    public float maxSpeed;

    public AbstractWeapon() {
        super();
        vector.isRemovable = true;
        vector.object = this;
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public void setLocation(double angle, Rectangle boundingBox) {
        vector.x = boundingBox.x + boundingBox.width;
        vector.y = boundingBox.y + boundingBox.height / 2f;
        double xVel = maxSpeed*Math.cos(angle);
        xVel = (angle >= Math.PI / 2 && angle <= 3 * Math.PI / 2) ? -1 * xVel : xVel;
        double yVel = maxSpeed*Math.sin(angle);
        yVel = (angle >= 0 && angle <= Math.PI) ? -1 * xVel : yVel;
        vector.velX = (float) xVel;
        vector.velY = (float) yVel;
    }

    @Override
    public void move() {
        super.move();

    }
}
