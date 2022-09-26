package com.engine.abstracts.object;

import com.engine.util.GameList;
import com.engine.util.VectorUtil;
import com.engine.util.generics.ConversionUtil;

import java.awt.*;

public abstract class Weapon extends Entity {

    public float maxSpeed;
    public int damage;

    public Weapon() {
        super();
        vector.isRemovable = true;
        vector.object = this;
    }

    public void setLocation(double angle, Rectangle boundingBox) {
        vector.x = boundingBox.x + boundingBox.width / 2f;
        vector.y = boundingBox.y + boundingBox.height / 2f;
        vector.velX = VectorUtil.calculateXVel(angle, maxSpeed);
        vector.velY = VectorUtil.calculateYVel(angle, maxSpeed);
    }

    @Override
    public void move() {
        super.move();
    }

    public void dealDamage(GameList<?> objects) {
        GameList<Entity> entities = ConversionUtil.getEntities(objects);

        entities.forEach(entity -> {
            Rectangle enemyBox = entity.boundingBox();
            if (intersects(enemyBox)) entity.takeDamage(damage);
        });
    }
}
