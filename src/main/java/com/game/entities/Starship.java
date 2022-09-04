package com.game.entities;

import com.game.Handler;
import com.game.graphics.Images;
import com.game.util.GameObject;
import com.game.util.GameObjectUtility;

import java.awt.*;
import java.util.Map;

public class Starship extends GameObject {

    private final Map<Character, Boolean> keyMap;
    private float x = 100f, y = 100f;

    public Starship(Handler handler) {
        keyMap = handler.getInputManager().keyMap;
        image = Images.getImage("starship");
    }

    @Override
    public void update() {
        move();
        shootLaser();
        GameObjectUtility.updateGameObjects(gameObjects);
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(image, (int) x, (int) y, null);
        graphics2D.setColor(Color.white);
        graphics2D.drawString("X : " + x, 20, 20);
        GameObjectUtility.renderGameObjects(gameObjects, graphics2D);
    }

    private void move() {
        keyMap.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .forEach((e) -> moveDir(e.getKey()));
    }

    private void moveDir(Character key) {
        if (x > 1000) markedForRemoval = true;
        if (key == 'w') {
            y -= 1.33f;
        }
        if (key == 'a') {
            x -= 1.33f;
        }
        if (key == 's') {
            y += 1.33f;
        }
        if (key == 'd') {
            x += 1.33f;
        }
    }

    private void shootLaser() {
        if (gameObjects.size() < 30 && keyMap.get('f') != null && keyMap.get('f')) {
            gameObjects.add(new Laser(x, y));
        }
    }
}
