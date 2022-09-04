package com.game;

import javax.swing.*;

public class Game {

    Timer timer;
    Handler handler;

    Game() {
        handler = new Handler();
        timer = new Timer(Constants.TICK_DELAY, (e) -> update());
    }

    void start() {
        timer.setRepeats(true);
        timer.start();

//        try {
//            Thread.sleep(1000);
//        } catch (Exception ignored) {}
    }

    void update() {
        handler.update();
        handler.render();
    }
}
