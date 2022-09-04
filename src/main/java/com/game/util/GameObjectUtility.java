package com.game.util;

import java.awt.*;
import java.util.List;

public class GameObjectUtility {

    public static void updateGameObjects(List<GameObject> gameObjects) {
        removeOldObjects(gameObjects);
        gameObjects.forEach(GameObject::update);
    }

    public static void renderGameObjects(List<GameObject> gameObjects, Graphics2D g) {
        gameObjects.forEach((gameObject) -> gameObject.render(g));
    }

    private static void removeOldObjects(List<GameObject> gameObjects) {
        List<GameObject> removableObjects = gameObjects.stream().filter(g -> g.markedForRemoval).toList();
        gameObjects.removeAll(removableObjects);
    }
}
