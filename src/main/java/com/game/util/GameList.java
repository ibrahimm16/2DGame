package com.game.util;

import com.game.util.abstracts.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameList<T extends GameObject> extends ArrayList<T> {

    public void update() {
        filter();
        forEach(T::update);
    }

    public void render(Graphics2D g) {
        forEach(t -> t.render(g));
    }

    private void filter() {
        GameList<T> removableObjects;
        removableObjects = stream()
                .filter(t -> t.removable)
                .collect(Collectors.toCollection(GameList::new));

        removableObjects.forEach(this::remove);
    }
}
