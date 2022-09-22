package com.game;

import com.engine.abstracts.object.GameObject;

public class Vector {

    public float x, y;
    public float velX, velY;
    public float distance = 0;
    public float range;
    public float angle;
    public GameObject object;


    public Vector(GameObject object) {
        this.object = object;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector v) {
        set(v);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    public void move() {
        x += velX;
        y += velY;
        double xDist = Math.pow(velX, 2);
        double yDist = Math.pow(velY, 2);
        distance += (float) Math.sqrt(xDist + yDist);
        if (distance > range) object.removable = true;
    }
}
