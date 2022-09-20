package com.engine.abstracts.object;

import com.engine.Constants;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllableObject extends Entity implements Serializable {

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

    @Override
    public void move() {
        inputMap.entrySet()
                .stream()
                .filter(e -> Constants.movementKeys.contains(e.getKey()))
                .filter(Map.Entry::getValue)
                .forEach(e -> fireEvent(movementEvents.get(e.getKey())));
    }

    public void generateEvents() {
        movementEvents = new HashMap<>();

        movementEvents.put('w', () -> y -= velY);
        movementEvents.put('a', () -> x -= velX);
        movementEvents.put('s', () -> y += velY);
        movementEvents.put('d', () -> x += velX);
    }

    public Rectangle boundingBox() {
        return new Rectangle((int) x, (int) y, image.getWidth(), image.getHeight());
    }
}
