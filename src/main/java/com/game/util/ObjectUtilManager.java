package com.game.util;

import com.game.entities.Laser;
import com.game.entities.Starship;

import java.util.List;

public class ObjectUtilManager {

    private static final ObjectUtil<Laser> laserUtil = new ObjectUtil<>();
    private static final ObjectUtil<Starship> starshipUtil = new ObjectUtil<>();

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
