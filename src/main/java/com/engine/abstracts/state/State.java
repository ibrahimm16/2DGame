package com.engine.abstracts.state;

import com.engine.Handler;
import com.engine.util.GameList;
import com.engine.util.InputMap;
import com.engine.abstracts.object.GameObject;

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
