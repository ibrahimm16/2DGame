package com.engine.abstracts.object;

import com.engine.Constants;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllableObject extends Entity implements Serializable {

    public double angle;
    private transient Map<Character, Runnable> movementEvents;

    public ControllableObject() {
        super();
        generateEvents();
    }

    @Override
    public void init() {
        super.init();
        generateEvents();
    }

    @Override
    public void update() {
        if (active) {
            move();
        }
        super.update();
    }

    public void generateEvents() {
        movementEvents = new HashMap<>();

        movementEvents.put('w', () -> vector.y -= vector.velY);
        movementEvents.put('a', () -> vector.x -= vector.velX);
        movementEvents.put('s', () -> vector.y += vector.velY);
        movementEvents.put('d', () -> vector.x += vector.velX);
    }

    @Override
    public void move() {
        inputMap.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .filter(e -> Constants.movementKeys.contains(e.getKey()))
                .forEach(e -> fireEvent(movementEvents.get(e.getKey())));
    }

    public Rectangle boundingBox() {
        return new Rectangle((int) vector.x, (int) vector.y, image.getWidth(), image.getHeight());
    }
}
