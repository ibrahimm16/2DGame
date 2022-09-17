package com.game.entities;

import com.engine.abstracts.state.States;
import com.engine.abstracts.object.ControllableObject;
import com.game.graphics.Colors;

import java.awt.*;

public class Starship extends ControllableObject {

    private int hp;

    public Starship() {
        super();
        x = 100;
        y = 100;
        speed = 2f;
        hp = 100;
        timer.add("addHP", 100);
        timer.add("dropHP", 200);
        timer.add("laser", 250);
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
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) x, (int) y, null);

        g.setColor(Color.white);
        g.drawString("bounding box : " + boundingBox(), 15, 40);
        g.drawString("Timer : " + timer, 15, 60);
        g.drawString("X : " + inputMap.getCursor().x + " Y : " + inputMap.getCursor().y, 15, 80);
        g.drawString("X : " + inputMap.getClick().x + " Y : " + inputMap.getClick().y, 15, 100);

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


        g.drawString("" + hp, x - 45, y + 5);
        g.drawRect((int) (x - 16), (int) (y-1), 21, 6);
        double hpWidth = (double) hp / (double) 100;
        g.fillRect((int) (x - 15), (int) y, (int) (hpWidth * 20), 5);
        super.render(g);
    }

    private void shootLaser() {
        if (inputMap.get('f')) {
            fireTimedEvent("laser", () -> {
                Laser laser = new Laser();
                laser.setLocation(new Point((int) x, (int) y));
                objects.add(laser);
            });
        }
    }
}
