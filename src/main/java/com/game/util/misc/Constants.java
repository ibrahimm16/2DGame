package com.game.util.misc;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Constants {

    public static final int TICK_DELAY = 3;
    public static final int TICK_RATE = 1000 / 3;
    public static final int WIDTH = 1200, HEIGHT = 800;
    public static Set<Character> keySet;
    public static List<Character> movementKeys;

    static {
        movementKeys = Arrays.asList('w', 'a', 's', 'd');
        keySet = Set.of('w', 'a', 's', 'd', 'f', '0', 'h', '1', '2');
    }
}
