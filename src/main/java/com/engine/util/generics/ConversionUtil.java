package com.engine.util.generics;

import com.engine.util.GameList;
import com.game.entities.Laser;
import com.game.entities.Starship;

import java.util.List;

public class ConversionUtil {

    // Type cast utility objects
    private static final Converter<Laser> laser = new Converter<>();
    private static final Converter<Starship> starship = new Converter<>();

    // Getter methods
    public static List<Laser> getLasers(GameList<?> gameObjects) {
        return laser.getObjects(Laser.class, gameObjects);
    }

    public static Laser getLaser(GameList<?> gameObjects) {
        return laser.getObject(Laser.class, gameObjects);
    }

    public static List<Starship> getStarships(GameList<?> gameObjects) {
        return starship.getObjects(Starship.class, gameObjects);
    }

    public static Starship getStarship(GameList<?> gameObjects) {
        return starship.getObject(Starship.class, gameObjects);
    }
}
