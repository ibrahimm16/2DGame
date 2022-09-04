package com.game.entities;

import com.game.Handler;
import com.game.util.GameObject;
import com.game.util.GameObjectUtility;

import java.awt.*;
import java.util.Map;

public class Player extends GameObject {

    private final Map<Character, Boolean> keyMap;

    public Player(Handler handler) {
        keyMap = handler.getInputManager().keyMap;
        gameObjects.add(new Starship(handler));
    }

    @Override
    public void update() {
        GameObjectUtility.updateGameObjects(gameObjects);
    }

    @Override
    public void render(Graphics2D graphics2D) {
        GameObjectUtility.renderGameObjects(gameObjects, graphics2D);
    }
}
