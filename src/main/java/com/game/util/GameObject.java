package com.game.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public abstract class GameObject {

    public int tickCounter = 0;
    public boolean isActive = true;
    public Boolean markedForRemoval = false;
    public Map<String, GameObject> objects = new HashMap<>();
    public Map<String, List<GameObject>> objectLists = new HashMap<>();

    public BufferedImage image;

    public void update() {
        GameObjectUtility.removeObjects(objects);
        GameObjectUtility.filterLists(objectLists);

        List<GameObject> allObjects = GameObjectUtility.flattenObjects(objects, objectLists);
        GameObjectUtility.updateObjects(allObjects);
        tickCounter++;
    }

    public void render(Graphics2D g) {
        List<GameObject> allObjects = GameObjectUtility.flattenObjects(objects, objectLists);
        GameObjectUtility.renderObjects(allObjects, g);
    }

    public void fireTimedEvent(int milliseconds, Runnable event) {
        if (TimeUtility.hasElapsed(milliseconds, tickCounter)) {
            event.run();
            tickCounter = 0;
        }
    }
}
