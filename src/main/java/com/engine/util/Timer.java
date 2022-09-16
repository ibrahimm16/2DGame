package com.engine.util;

import com.engine.Constants;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Timer implements Serializable {

    // The Integer array part of this map holds two values
    // Index 1 : timer delay
    // Index 2 : time since last firing
    private final Map<String, Integer[]> timers = new HashMap<>();

    public void add(String name, Integer delay) {
        timers.put(name, new Integer[]{delay, delay});
    }

    public void reset(String name) {
        Integer[] timeValues = timers.get(name);
        timeValues[1] = 0;
    }

    public void readyTimer(String name) {
        Integer[] timeValues = timers.get(name);
        timeValues[1] = timeValues[0];
    }

    public Boolean canFire(String name) {
        Integer[] timeValues = timers.get(name);
        return timeValues[1] >= timeValues[0];
    }

    public void update() {
        timers.forEach((name, timer) -> {
            Integer[] timeValues = timers.get(name);
            timeValues[1] = timeValues[1] + Constants.TICK_DELAY;
        });
    }
}
