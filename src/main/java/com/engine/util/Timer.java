package com.engine.util;

import com.engine.Constants;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Timer implements Serializable {

    // The Integer array part of this map holds two values
    // Index 0 : timer delay
    // Index 1 : time since last firing
    private final Map<String, Integer[]> timers = new HashMap<>();

    public void add(String name, Integer delay) {
        timers.put(name, new Integer[]{delay, delay});
    }

    public void reset(String name) {
        Integer[] timeValues = timers.get(name);
        timeValues[1] = 0;
    }

    public boolean canFire(String name) {
        Integer[] timeValues = timers.get(name);
        return timeValues[1] >= timeValues[0];
    }

    public void update() {
        timers.forEach((name, timer) -> {
            Integer[] timeValues = timers.get(name);
            timeValues[1] = timeValues[1] + Constants.TICK_DELAY;
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        timers.forEach((key, value) -> sb.append(key).append(" : ").append(Arrays.toString(value)).append(", "));
        sb.replace(sb.length() - 2, sb.length() - 1, "");
        sb.append(" }");

        return sb.toString();
    }
}
