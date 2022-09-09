package com.game.util.gameobject;

import com.game.util.abstracts.GameObject;

import java.util.List;

public class Converter<T extends GameObject> {

    public List<T> getObjects(Class<T> typeClass, List<GameObject> gameObjects) {
        // returns the list of objects that matches the specified type and casts them to it
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .toList();
    }

    public T getObject(Class<T> typeClass, List<GameObject> gameObjects) {
        // returns the first object of a specified type and casts it or else null
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .findFirst()
                .orElse(null);
    }
}
