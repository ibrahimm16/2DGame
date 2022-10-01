package com.engine.util;

import com.engine.abstracts.object.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameList<T extends GameObject> extends ArrayList<T> {

    public static GameList<GameObject> allObjects = new GameList<>();

    @Override
    public boolean add(T t) {
        if (allObjects.stream().noneMatch((o) -> o == t)) {
            allObjects.add(0,t);
        }
        return super.add(t);
    }


    public boolean remove(Object o) {
        int index = allObjects.indexOf(o);
        allObjects.remove(index);
        return super.remove(o);
    }

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
