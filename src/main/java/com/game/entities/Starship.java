package com.game.entities;

import com.game.Handler;
import com.game.graphics.Images;
import com.game.util.GameObject;
import com.game.util.ObjectUtilManager;

import java.awt.*;
import java.util.List;
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
        fireTimedEvent(250, this::shootLaser);
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        List<Laser> lasers = ObjectUtilManager.getLasers(objects);


        g.drawImage(image, (int) x, (int) y, null);
        g.setColor(Color.white);
        g.drawString("X : " + x, 15, 20);
        g.drawString("Y : " + y, 15, 40);
        g.drawString("Lasers : " + lasers.size(), 15, 60);
        g.drawString("tickCounter : " + tickCounter, 15, 80);
        super.render(g);
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
        if (keyMap.get('f') != null && keyMap.get('f'))
            objects.add(new Laser(x, y));
    }

    @Override
    public String toString() {
        return "Starship{" +
                "keyMap=" + keyMap +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
