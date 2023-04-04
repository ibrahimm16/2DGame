package com.game;

import com.engine.Constants;
import com.engine.Handler;

public class Game {

    boolean loop = true;
    Handler handler;

    void start() {
        handler = Handler.get();

        while (loop) update();
    }

    void update() {
        handler.update();
        handler.render();

        try {
            Thread.sleep(1000 / Constants.TICK_RATE);
        } catch (Exception ignored) {}
    }
}
