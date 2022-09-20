package com.engine.abstracts.object;

import java.awt.*;

public class Entity extends GameObject {

    public float x, y;
    public float velX, velY;
    public int hp;
    public int damage;

    public Entity() {
        super();
    }

    @Override
    public void update() {
        move();
        super.update();
    }

    public void move() {
        x += velX;
        y += velY;
    }

    public void dealDamage(Entity entity) {
        Rectangle enemyBox = entity.boundingBox();
        Boolean hit = intersects(enemyBox);

        if (hit) {
            int newHP = entity.hp - damage;
            entity.hp = Math.max(newHP, 0);
        }
    }

    public Rectangle boundingBox() {
        return new Rectangle((int) x, (int) y, image.getWidth(), image.getHeight());
    }

    public Boolean intersects(Rectangle enemyBox) {
        return enemyBox.intersects(enemyBox);
    }
}
