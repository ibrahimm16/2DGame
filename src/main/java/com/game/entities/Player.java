package com.game.entities;

import com.game.Handler;
import com.game.util.GameObject;

import java.awt.*;
import java.util.Map;

public class Player extends GameObject {

    private final String starship = "starship";

    private final Map<Character, Boolean> keyMap;

    public Player(Handler handler) {
        keyMap = handler.getInputManager().keyMap;
        objects.put(starship, new Starship(handler));
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
