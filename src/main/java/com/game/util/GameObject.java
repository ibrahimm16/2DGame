package com.game.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public abstract class GameObject {

    public int tickCounter = 0;
    public boolean isActive = true;
    public Boolean markedForRemoval = false;
    public List<GameObject> objects = new ArrayList<>();
    public BufferedImage image;

    public void update() {
        CommonUtil.removeObjects(objects);
        CommonUtil.updateObjects(objects);

        tickCounter++;
    }

    public void render(Graphics2D g) {
        CommonUtil.renderObjects(objects, g);
    }

    public void fireTimedEvent(int milliseconds, Runnable event) {
        if (TimeUtility.hasElapsed(milliseconds, tickCounter)) {
            event.run();
            tickCounter = 0;
        }
    }

    public void fireEvent(GameObject object, Runnable event) {
        if (object != null)
            event.run();
    }
}
