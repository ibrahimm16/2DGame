package com.game;

import com.game.graphics.Display;
import com.game.states.StateManager;
import com.game.util.InputMap;

import java.awt.*;

public class Handler {

    public static Handler handler;
    public InputMap inputMap;
    public Display display;
    public StateManager stateManager;

    Handler() {
        handler = this;
        inputMap = new InputMap();
        display = new Display();
        stateManager = new StateManager();
    }

    public void update() {
        stateManager.update();
    }

    public void render() {
        Graphics2D g = display.render();
        stateManager.render(g);
        display.show();
    }
}
