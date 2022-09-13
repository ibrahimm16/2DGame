package com.game.util.gameobject;

import com.game.util.GameList;
import com.game.util.abstracts.GameObject;

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
