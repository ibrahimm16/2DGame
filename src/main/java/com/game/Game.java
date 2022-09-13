package com.game;

import com.game.util.misc.Constants;

public class Game {

    Boolean loop = true;
    Handler handler;

    void start() {
        handler = new Handler();

        while (loop) update();
    }

    void update() {
        handler.update();
        handler.render();

        try {
            Thread.sleep(1000 / Constants.TICK_RATE);
        } catch (Exception ignored) {
        }
    }
}
