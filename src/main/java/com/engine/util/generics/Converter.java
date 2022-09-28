package com.engine.util.generics;

import com.engine.abstracts.object.GameObject;
import com.engine.util.GameList;

import java.util.stream.Collectors;

public class Converter<T extends GameObject> {

    public GameList<T> getObjects(Class<T> typeClass, GameList<?> gameObjects) {
        // returns the list of objects that matches the specified type and casts them to it
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .collect(Collectors.toCollection(GameList::new));
    }

    public T getObject(Class<T> typeClass, GameList<?> gameObjects) {
        // returns the first object of a specified type and casts it or else null
        return gameObjects
                .stream()
                .filter(typeClass::isInstance)
                .map(typeClass::cast)
                .findFirst()
                .orElse(null);
    }
}
