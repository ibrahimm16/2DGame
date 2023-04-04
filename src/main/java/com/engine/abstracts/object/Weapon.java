package com.engine.abstracts.object;

import com.engine.util.GameList;
import com.engine.util.VectorUtil;
import com.engine.util.generics.ConversionUtil;

import java.awt.*;

public abstract class Weapon extends Entity {

    public float maxSpeed;
    public int damage;
    public double angle;
    public double width;
    public double height;

    public Weapon() {
        super();
        vector.removable = true;
        vector.object = this;
    }

    public void rotate(Graphics2D graphics2D, int factor) {
        graphics2D.rotate(angle*factor, vector.x + (width / 2), vector.y + (height / 2));

    }

    public void setLocation(double angle, Rectangle boundingBox) {
        // We want the projectile to exit from the tip of the ship
        this.angle = angle;
        float radius = (float)(boundingBox.width / 2);
        double originalX = (double)(boundingBox.x + boundingBox.width / 2);
        double originalY = (double)(boundingBox.y + boundingBox.height / 2);
        vector.x = (float)(originalX + (radius * Math.cos(angle)));
        vector.y = (float)(originalY + (radius * Math.sin(angle)));

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
            if (intersects(enemyBox)) entity.damage(damage);
        });
    }
}
