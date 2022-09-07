package com.game.entities;

import com.game.Handler;
import com.game.graphics.Images;
import com.game.util.GameObject;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Starship extends GameObject {

    private final Map<Character, Boolean> keyMap;
    private float x = 100f, y = 100f;
    private List<GameObject> lasers = new ArrayList<>();

    public Starship(Handler handler) {
        keyMap = handler.getInputManager().keyMap;
        image = Images.getImage("starship");
        objectLists.put("lasers", lasers);
    }

    @Override
    public void update() {
        move();
        shootLaser();
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) x, (int) y, null);
        g.setColor(Color.white);
        g.drawString("X : " + x, 15, 20);
        g.drawString("Y : " + y, 15, 40);
        g.drawString("Lasers : " + lasers.size(), 15, 60);
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
            fireTimedEvent(100, () -> lasers.add(new Laser(x, y)));
    }
}
