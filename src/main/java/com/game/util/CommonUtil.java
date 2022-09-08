package com.game.util;

import java.awt.*;
import java.util.List;

public class CommonUtil {

    public static void removeObjects(List<GameObject> gameObjects) {
        List<GameObject> objectsToRemove = gameObjects.stream().filter(o -> o.markedForRemoval).toList();
        objectsToRemove.forEach(gameObjects::remove);
    }

    public static void updateObjects(List<GameObject> gameObjects) {
        gameObjects.forEach(GameObject::update);
    }

    public static void renderObjects(List<GameObject> gameObjects, Graphics2D g) {
        gameObjects.forEach(o -> o.render(g));
    }
}
