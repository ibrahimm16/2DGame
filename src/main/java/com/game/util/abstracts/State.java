package com.game.util.abstracts;

import com.game.Handler;
import com.game.util.GameList;
import com.game.util.InputMap;

import java.awt.*;

public abstract class State {

    public Handler handler;
    public InputMap inputMap;
    public Boolean active;
    public GameList<GameObject> objects;

    {
        handler = Handler.handler;
        inputMap = handler.inputMap;
        active = true;
        objects = new GameList<>();
    }

    public void update() {
        if (active) {
            objects.update();
        }
    }

    public void render(Graphics2D g) {
        if (active) {
            objects.render(g);
        }
    }
}
