package com.engine.util;

import com.engine.Constants;

public class TimeUtil {

    public static boolean hasElapsed(int milliseconds, int tickCounter) {
        return (tickCounter * Constants.TICK_DELAY > milliseconds);
    }
}
