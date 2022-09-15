package com.game.entities;


import com.engine.abstracts.state.States;
import com.engine.abstracts.object.ControllableObject;
import com.engine.util.generics.ConversionUtil;

import java.awt.*;
import java.util.List;

public class Starship extends ControllableObject {

    public Starship() {
        super();
        x = 100;
        y = 100;
        speed = 2f;
    }

    @Override
    public void update() {
        if (inputMap.get('h')) {
            handler.stateManager.setActiveState(States.MENU);
            fireTimedEvent(5, () -> {
                System.out.println(this);
                ticks = 0;
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
