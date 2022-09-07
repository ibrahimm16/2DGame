package com.game.util;

import com.game.Constants;

public class TimeUtility {

    public static boolean hasElapsed(int milliseconds, int tickCounter) {
        return (tickCounter * Constants.TICK_DELAY > milliseconds);
    }
}
