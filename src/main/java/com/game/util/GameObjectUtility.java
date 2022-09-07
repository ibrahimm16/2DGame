package com.game.util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GameObjectUtility {

    public static void filterLists(Map<String, List<GameObject>> objectLists) {
        objectLists.values().forEach(GameObjectUtility::removeFromList);
    }

    public static void removeObjects(Map<String, GameObject> objectLists) {
        List<String> markedForRemoval = objectLists
                .entrySet()
                .stream()
                .filter((e) -> e.getValue().markedForRemoval)
                .map(Map.Entry::getKey)
                .toList();

        markedForRemoval.forEach(objectLists::remove);
    }

    private static void removeFromList(List<GameObject> gameObjects) {
        List<GameObject> removableObjects = gameObjects.stream().filter(g -> g.markedForRemoval).toList();
        gameObjects.removeAll(removableObjects);
    }

    public static void updateObjects(List<GameObject> gameObjects) {
        gameObjects.forEach(GameObject::update);
    }

    public static void renderObjects(List<GameObject> gameObjects, Graphics2D g) {
        gameObjects.forEach(o -> o.render(g));
    }

    public static List<GameObject> flattenObjects(Map<String, GameObject> objects, Map<String, List<GameObject>> objectLists) {
        List<GameObject> flattenedObjects = new ArrayList<>();

        flattenedObjects.addAll(objects.values());
        flattenedObjects.addAll(
                objectLists
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .toList()
        );

        return flattenedObjects;
    }
}
