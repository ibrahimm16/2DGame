package com.engine.abstracts.object;

import com.engine.util.Vector;

import java.awt.*;

public class Entity extends GameObject {

    public Vector vector;
    public double hp;

    public Entity() {
        super();
        vector = new Vector();
    }

    @Override
    public void update() {
        removable = vector.removable;
        move();
        super.update();
    }

    public void move() {
        vector.move();
    }

    public void damage(double damage) {
        hp = Math.max((hp - damage), 0);
        removable = (hp == 0);
    }

    public Rectangle boundingBox() {
        int width = (image == null) ? 0 : image.getWidth();
        int height = (image == null) ? 0 : image.getHeight();

        return new Rectangle((int) vector.x, (int) vector.y, width, height);
    }

    public boolean intersects(Rectangle enemyBox) {
        return boundingBox().intersects(enemyBox);
    }
}
