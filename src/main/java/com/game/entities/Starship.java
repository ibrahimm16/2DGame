package com.game.entities;

import com.engine.abstracts.state.States;
import com.engine.abstracts.object.ControllableObject;
import com.engine.util.VectorUtil;
import com.game.entities.player.Missile;
import com.game.graphics.Colors;

import java.awt.*;

public class Starship extends ControllableObject {

    private int hp;

    public Starship() {
        super();
        vector.x = 100;
        vector.y = 100;
        vector.velX = 1f;
        vector.velY = 1f;
        hp = 100;
        timer.add("addHP", 100);
        timer.add("dropHP", 200);
        timer.add("laser", 2);
        timer.add("missile", 5);
    }

    @Override
    public void update() {
        if (inputMap.get('h')) {
            handler.stateManager.setActiveState(States.MENU);
        }

        if (inputMap.get('4')) {
            fireTimedEvent("addHP", () -> {
                if (hp != 1000) {
                    int newHp = hp + (int) (Math.random() * 25.0);
                    hp = Math.min(100, newHp);
                }
            });
        }
        if (inputMap.get('5')) {
            fireTimedEvent("dropHP", () -> {
                if (hp != 0) {
//                    int newHp = hp - (int) (Math.random() * 75.0);
                    hp = Math.max(0, hp - 5);
                }
            });
        }

        shootLaser();
        shootMissile();
//        super.update();
        move();
        objects.update();
        timer.update();
    }

    @Override
    public void render(Graphics2D g) {
        int centerY = (int)(vector.y + image.getHeight() / 2);
        int centerX = (int)(vector.x + image.getWidth() / 2);
        angle = VectorUtil.calculateAngle(new Point(centerX, centerY), inputMap.getCursor());
        g.rotate(angle, centerX, centerY);
        g.drawImage(image, (int) vector.x, (int) vector.y, null);
        g.rotate(-1*angle, centerX, centerY);
        g.setColor(Color.white);
        g.drawString("bounding box : " + boundingBox(), 15, 20);
        g.drawString("Timer : " + timer, 15, 40);
        g.drawString("X : " + inputMap.getCursor().x + " Y : " + inputMap.getCursor().y, 15, 60);
        g.drawString("X : " + inputMap.getClick().x + " Y : " + inputMap.getClick().y, 15, 80);
        g.drawString("angle : " + angle, 15, 100);

//        g.drawRect((int) (x - 16), (int) (y-1), 21, 6);

        if (hp > 75) {
            g.setColor(Colors.green);
        }
        else if (hp > 40) {
            g.setColor(Colors.yellow);
        }
        else if (hp > 20) {
            g.setColor(Colors.orange);
        }
        else {
            g.setColor(Colors.red);
        }


        g.drawString("" + hp, vector.x - 45, vector.y + 5);
        g.drawRect((int) (vector.x - 16), (int) (vector.y-1), 21, 6);
        double hpWidth = (double) hp / (double) 100;
        g.fillRect((int) (vector.x - 15), (int) vector.y, (int) (hpWidth * 20), 5);
        super.render(g);
    }

    private void shootLaser() {
        if (inputMap.get('f')||inputMap.isPressed()) {
            fireTimedEvent("laser", () -> {
                Laser laser = new Laser();
                laser.setLocation(angle, boundingBox());
                objects.add(laser);
            });
        }
    }
    private void shootMissile() {
        if (inputMap.get('q')||inputMap.isPressed()) {
            fireTimedEvent("missile", () -> {
                Missile missile = new Missile();
                missile.setLocation(angle, boundingBox());
                objects.add(missile);
            });
        }
    }
}
