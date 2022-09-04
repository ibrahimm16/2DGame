package com.game;

import com.game.entities.Player;
import com.game.graphics.Display;
import com.game.util.GameObject;
import com.game.util.GameObjectUtility;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;

@Data
public class Handler extends GameObject {
    private InputManager inputManager;
    Display display;
    Player player;

    Handler() {
        gameObjects = new ArrayList<>();
        inputManager = new InputManager();
        display = new Display(this);
        player = new Player(this);
        gameObjects.add(player);
    }

    @Override
    public void update() {
        GameObjectUtility.updateGameObjects(gameObjects);
    }

    public void render() {
        Graphics2D g = display.render();
        GameObjectUtility.renderGameObjects(gameObjects, g);
        display.show();
    }
}
