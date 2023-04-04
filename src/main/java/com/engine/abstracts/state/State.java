package com.engine.abstracts.state;

import com.engine.Handler;
import com.engine.abstracts.object.GameObject;
import com.engine.util.Button;
import com.engine.util.GameList;
import com.engine.util.InputMap;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class State {

    public Handler handler;
    public InputMap inputMap;
    public boolean active;
    public GameList<GameObject> objects;
    public Map<String, Button> buttons;

    public State() {
        handler = Handler.get();
        inputMap = handler.inputMap;
        objects = new GameList<>();
        buttons = new HashMap<>();
        setButtons();
    }

    public void update() {
        if (active) {
            buttons.values().forEach(b -> {
                if (b.isClicked(inputMap)) b.fireEvent();
            });
            objects.update();
        }
    }

    public void render(Graphics2D g) {
        if (active) {
            buttons.values().forEach(b -> b.render(g));
            objects.render(g);
        }
    }

    public void setButtons() {}
}
