package com.game;

import com.game.entities.player.Player;
import com.game.graphics.Display;
import com.game.util.abstracts.GameObject;
import com.game.util.InputMap;

import java.awt.*;

public class Handler extends GameObject {

    public static Handler handler;
    public InputMap inputMap;
    public Display display;

    Handler() {
        handler = this;
        inputMap = new InputMap();
        display = new Display();
        objects.add(new Player());
    }

    @Override
    public void update() {
        super.update();
    }

    public void render() {
        Graphics2D g = display.render();
        super.render(g);
        display.show();
    }
}
