package com.game.util.abstracts;

import com.game.util.misc.Constants;
import com.game.util.InputMap;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class ControllableObject extends GameObject {

    public final InputMap inputMap;
    private final Map<Character, Runnable> movementEvents;
    public float x, y, speed;

    public ControllableObject() {
        inputMap = handler.inputMap;
        movementEvents = new HashMap<>();

        movementEvents.put('w', () -> y -= speed);
        movementEvents.put('a', () -> x -= speed);
        movementEvents.put('s', () -> y += speed);
        movementEvents.put('d', () -> x += speed);
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
}
