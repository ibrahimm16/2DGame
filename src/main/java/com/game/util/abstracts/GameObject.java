package com.game.util.abstracts;

import com.game.Handler;
import com.game.util.GameList;
import com.game.util.InputMap;
import com.game.util.misc.TimeUtility;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    public Handler handler;
    public Integer ticks;
    public Boolean active;
    public Boolean removable;
    public GameList<GameObject> objects;
    public BufferedImage image;
    public InputMap inputMap;

    {
        handler = Handler.handler;
        ticks = 0;
        active = true;
        removable = false;
        objects = new GameList<>();

        if (handler != null) {
            inputMap = handler.inputMap;
        }
    }

    public void update() {
        objects.update();
        ticks++;
    }

    public void render(Graphics2D g) {
        objects.render(g);
    }

    public void fireEvent(Runnable event) {
        if (event != null) event.run();
    }

    public void fireTimedEvent(int milliseconds, Runnable event) {
        if (TimeUtility.hasElapsed(milliseconds, ticks) && event != null) {
            event.run();
        }
    }

    public void nullCheckEvent(GameObject object, Runnable event) {
        if (object != null && event != null) event.run();
    }
}
