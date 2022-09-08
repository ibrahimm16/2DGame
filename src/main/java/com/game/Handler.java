package com.game;

import com.game.entities.Player;
import com.game.graphics.Display;
import com.game.util.GameObject;
import lombok.Data;

import java.awt.*;

@Data
public class Handler extends GameObject {
    private InputManager inputManager;
    Display display;

    Handler() {
        inputManager = new InputManager();
        display = new Display(this);
        objects.add(new Player(this));
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
