package com.engine.util;

import com.engine.abstracts.object.GameObject;
import com.engine.util.VectorUtil;

import java.awt.*;
import java.io.Serializable;

public class Vector implements Serializable {

    public float x, y;
    public float velX, velY;
    public float distance;
    public float range;
    public float angle;
    public GameObject object;
    public Boolean isRemovable = false;

    public Vector() {

    }

    public Vector(GameObject object) {
        this.object = object;
    }

    public float Magnitude() {
        return (float)Math.sqrt(x*x + y*y);
    }

    public float Normalize() {
        float mag = VectorUtil.magnitude(this);
        float x = this.x / mag;
        float y = this.y / mag;
        return 0f;
    }

    public void move() {
        x += velX;
        y += velY;
        double xDist = Math.pow(velX, 2);
        double yDist = Math.pow(velY, 2);
        distance += (float) Math.sqrt(xDist + yDist);
        if (distance > range && isRemovable) object.removable = true;
    }

    public Point coordinates() {
        return new Point((int) x, (int) y);
    }
}
