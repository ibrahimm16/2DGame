package com.engine.util.generics;

import com.engine.abstracts.object.Entity;
import com.engine.util.GameList;
import com.game.entities.Laser;
import com.game.entities.Starship;

public class ConversionUtil {

    // Type cast utility objects
    private static final Converter<Laser> laser = new Converter<>();
    private static final Converter<Starship> starship = new Converter<>();
    private static final Converter<Entity> entity = new Converter<>();

    // Getter methods
    public static GameList<Laser> getLasers(GameList<?> gameObjects) {
        return laser.getObjects(Laser.class, gameObjects);
    }

    public static Laser getLaser(GameList<?> gameObjects) {
        return laser.getObject(Laser.class, gameObjects);
    }

    public static GameList<Starship> getStarships(GameList<?> gameObjects) {
        return starship.getObjects(Starship.class, gameObjects);
    }

    public static Starship getStarship(GameList<?> gameObjects) {
        return starship.getObject(Starship.class, gameObjects);
    }

    public static GameList<Entity> getEntities(GameList<?> gameObjects) {
        return entity.getObjects(Entity.class, gameObjects);
    }

    public static Entity getEntity(GameList<?> gameObjects) {
        return entity.getObject(Entity.class, gameObjects);
    }
}
