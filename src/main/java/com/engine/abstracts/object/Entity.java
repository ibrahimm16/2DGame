package com.engine.abstracts.object;

import com.engine.util.Vector;

import java.awt.*;


public class Entity extends GameObject {

    public Vector vector = new Vector();
    public int hp;

    public Entity() {
        super();
    }

    @Override
    public void update() {
        move();
        super.update();
    }

    public void move() {
        vector.move();
    }

    public void takeDamage(int damage) {
        int newHP = hp - damage;
        hp = Math.max(newHP, 0);
        if (hp == 0) removable = true;
    }

    public Rectangle boundingBox() {
        return new Rectangle((int) vector.x, (int) vector.y, image.getWidth(), image.getHeight());
    }

    public Boolean intersects(Rectangle enemyBox) {
        return enemyBox.intersects(enemyBox);
    }
}
