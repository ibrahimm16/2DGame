package com.engine.util.generics;

import com.game.entities.Starship;

public class SerializerUtil {

    private static final Serializer<Starship> starship = new Serializer<>();

    public static void saveStarship(Starship s) {
        starship.serialize(s);
    }

    public static Starship loadStarship() {
        Starship s = starship.deserialize(Starship.class);
        s.init();
        return s;
    }
}
