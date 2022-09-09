package com.game.entities;

import com.game.graphics.Images;
import com.game.util.abstracts.ControllableObject;
import com.game.util.gameobject.ConversionUtil;

import java.awt.*;
import java.util.List;

public class Starship extends ControllableObject {

    public Starship() {
        super();
        x = 100;
        y = 100;
        speed = 2f;
        image = Images.getImage("starship");
    }

    @Override
    public void update() {
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
}
