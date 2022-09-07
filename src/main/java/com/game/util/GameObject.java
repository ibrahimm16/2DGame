package com.game.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<GameObject> flattenedObjects = GameObjectUtility.flattenObjects(objects, objectLists);
        GameObjectUtility.updateObjects(flattenedObjects);

        tickCounter++;
    }

    public void render(Graphics2D g) {
        List<GameObject> flattenedObjects = GameObjectUtility.flattenObjects(objects, objectLists);
        GameObjectUtility.renderObjects(flattenedObjects, g);
    }

    public void fireTimedEvent(int milliseconds, Runnable event) {
        if (TimeUtility.hasElapsed(milliseconds, tickCounter)) {
            event.run();
            tickCounter = 0;
        }
    }
}
