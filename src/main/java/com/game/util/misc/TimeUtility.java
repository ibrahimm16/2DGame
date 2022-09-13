package com.game.util.misc;

public class TimeUtility {

    public static boolean hasElapsed(int milliseconds, int tickCounter) {
        return (tickCounter * Constants.TICK_DELAY > milliseconds);
    }
}
