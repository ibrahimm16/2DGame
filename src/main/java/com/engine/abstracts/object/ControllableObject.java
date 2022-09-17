package com.engine.abstracts.object;

import com.engine.Constants;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class ControllableObject extends GameObject implements Serializable {

    private transient Map<Character, Runnable> movementEvents;
    public float x, y, speed;

    public ControllableObject() {
        super();
        generateEvents();
    }

    @Override
    public void deserialize() {
        super.deserialize();
        generateEvents();
    }

    @Override
    public void update() {
        if (active) {
            move();
        }
        super.update();
    }

    public void move() {
        // Filters the map by movement keys and pressed keys
        inputMap.entrySet()
                .stream()
                .filter(e -> Constants.movementKeys.contains(e.getKey()))
                .filter(Map.Entry::getValue)
                .forEach(e -> fireEvent(movementEvents.get(e.getKey())));
    }

    public void generateEvents() {
        movementEvents = new HashMap<>();

        movementEvents.put('w', () -> y -= speed);
        movementEvents.put('a', () -> x -= speed);
        movementEvents.put('s', () -> y += speed);
        movementEvents.put('d', () -> x += speed);
    }

    public Rectangle boundingBox() {
        return new Rectangle((int) x, (int) y, image.getWidth(), image.getHeight());
    }
}
