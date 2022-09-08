package com.game.util;

import java.util.List;

public class ObjectUtil<T extends GameObject> {

    public List<T> getObjects(Class<T> typeClass, List<GameObject> gameObjects) {
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .toList();
    }

    public T getObject(Class<T> typeClass, List<GameObject> gameObjects) {
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .findFirst()
                .orElse(null);
    }
}
