package com.game.util.gameobject;

import com.game.entities.Laser;
import com.game.entities.Starship;
import com.game.util.abstracts.GameObject;

import java.util.List;

public class ConversionUtil {

    // Type cast utility objects
    private static final Converter<Laser> laserUtil = new Converter<>();
    private static final Converter<Starship> starshipUtil = new Converter<>();

    // Getter methods
    public static List<Laser> getLasers(List<GameObject> gameObjects) {
        return laserUtil.getObjects(Laser.class, gameObjects);
    }

    public static Laser getLaser(List<GameObject> gameObjects) {
        return laserUtil.getObject(Laser.class, gameObjects);
    }

    public static List<Starship> getStarships(List<GameObject> gameObjects) {
        return starshipUtil.getObjects(Starship.class, gameObjects);
    }

    public static Starship getStarship(List<GameObject> gameObjects) {
        return starshipUtil.getObject(Starship.class, gameObjects);
    }
}
