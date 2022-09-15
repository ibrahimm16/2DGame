package com.game.entities;


import com.engine.abstracts.state.States;
import com.engine.abstracts.object.ControllableObject;
import com.engine.util.generics.ConversionUtil;

import java.awt.*;
import java.util.List;

public class Starship extends ControllableObject {

    private int hp;

    public Starship() {
        super();
        x = 100;
        y = 100;
        speed = 2f;
        hp = 1000;
    }

    @Override
    public void update() {
        if (inputMap.get('h')) {
            handler.stateManager.setActiveState(States.MENU);
        }


        if (inputMap.get('4')) {
            fireTimedEvent(200, () -> {
                ticks = 0;
                if (hp != 1000) {
                    int newHp = hp + (int) (Math.random() * 75.0);
                    hp = Math.min(1000, newHp);
                }
            });
        }
        if (inputMap.get('5')) {
            fireTimedEvent(200, () -> {
                ticks = 0;
                if (hp != 0) {
//                    int newHp = hp - (int) (Math.random() * 75.0);
                    hp = Math.max(0, hp - 25);
                }
            });
        }


        fireTimedEvent(250, this::shootLaser);
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        List<Laser> lasers = ConversionUtil.getLasers(objects);


        g.drawImage(image, (int) x, (int) y, null);
        g.setColor(Color.white);
        g.drawString("X : " + x, 15, 20);
        g.drawString("Y : " + y, 15, 40);
        g.drawString("Lasers : " + lasers, 15, 60);
        g.drawString("Time Elapsed : " + ticks, 15, 80);
        g.drawString("X : " + inputMap.getCursor().x + " Y : " + inputMap.getCursor().y, 15, 120);
        g.drawString("X : " + inputMap.getClick().x + " Y : " + inputMap.getClick().y, 15, 140);
        g.drawString(inputMap.toString(), 15, 100);
        g.drawString("" + hp, x - 45, y + 5);

        Color green = new Color(35, 87, 22);
        Color yellow = new Color(219, 213, 42);
        Color orange = new Color(191, 136, 84);
        Color red = new Color(133, 27, 27);

        g.drawRect((int) (x - 16), (int) (y-1), 21, 6);

        if (hp > 750) {
            g.setColor(green);
        }
        else if (hp > 400) {
            g.setColor(yellow);
        }
        else if (hp > 175) {
            g.setColor(orange);
        }
        else {
            g.setColor(red);
        }


//        g.drawRect((int) (x - 16), (int) (y-1), 21, 6);
        double hpWidth = (double) hp / (double) 1000;
        g.fillRect((int) (x - 15), (int) y, (int) (hpWidth * 20), 5);
        super.render(g);
    }

    private void shootLaser() {
        if (inputMap.get('f')) {
            objects.add(new Laser(x, y));
            ticks = 0;
        }
    }

    @Override
    public String toString() {
        return "Starship{" +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", objects=" + objects +
                ", inputMap=" + inputMap +
                ", ticks=" + ticks +
                ", active=" + active +
                ", removable=" + removable +
                '}';
    }
}
