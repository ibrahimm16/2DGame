package com.engine;

import com.engine.display.Display;
import com.engine.abstracts.state.StateManager;
import com.engine.util.GameList;
import com.engine.util.InputMap;

import java.awt.*;

public class Handler {

    private static Handler handler = new Handler();
    public InputMap inputMap;
    public Display display;
    public StateManager stateManager;

    private Handler() {
        handler = this;
        inputMap = new InputMap();
        display = new Display();
        stateManager = new StateManager();
    }

    public static Handler get() {
        return handler;
    }

    public void update() {
        stateManager.update();
    }

    public void render() {
        Graphics2D g = display.render();
        stateManager.render(g);
        g.setColor(Color.white);
        g.drawString("" + GameList.allObjects.size(), 15, 700);
        display.show();
    }
}
