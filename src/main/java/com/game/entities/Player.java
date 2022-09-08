package com.game.entities;

import com.game.Handler;
import com.game.util.GameObject;
import com.game.util.ObjectUtil;

import java.awt.*;
import java.util.Map;

public class Player extends GameObject {

    private final Map<Character, Boolean> keyMap;
    public static ObjectUtil<Player> util = new ObjectUtil<>();

    public Player(Handler handler) {
        keyMap = handler.getInputManager().keyMap;
        objects.add(new Starship(handler));
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
