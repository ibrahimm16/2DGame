package com.engine.util;

import com.engine.abstracts.object.GameObject;

import java.io.Serializable;

public class Vector implements Serializable {

    public float x, y;
    public float velX, velY;
    public float distance;
    public float range = -1;
    public float angle;
    public GameObject object;
    public boolean removable = false;

    public Vector() {}

    public void move() {
        x += velX;
        y += velY;
        double xDist = Math.pow(velX, 2);
        double yDist = Math.pow(velY, 2);
        distance += (float) Math.sqrt(xDist + yDist);
        checkForRemoval();
    }

    private void checkForRemoval() {
        if (range != -1 && range >= distance) removable = true;
    }
}
