package com.engine.abstracts.object;

import java.awt.*;
import java.io.Serializable;

public abstract class AbstractWeapon extends Entity {


    public Color color;
    float maxSpeed;

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
        xVel = (angle >= 90 && angle <= 270) ? -1 * xVel : xVel;
        double yVel = maxSpeed*Math.sin(angle);
        yVel = (angle >= 0 && angle <= 180) ? -1 * xVel : yVel;

    }

    @Override
    public void move() {
        super.move();

    }
}
