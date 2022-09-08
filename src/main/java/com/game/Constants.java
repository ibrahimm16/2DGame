package com.game;

import com.game.entities.Laser;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final int TICK_DELAY = 3;
    public static final int WIDTH = 1200, HEIGHT = 700;
    public static final Map<String, Class<?>> classes;

    static {
        classes = new HashMap<>();
        classes.put("lasers", Laser.class);
    }
}
