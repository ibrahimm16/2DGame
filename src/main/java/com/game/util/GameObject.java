package com.game.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    public Boolean markedForRemoval = false;
    public List<GameObject> gameObjects = new ArrayList<>();

    public BufferedImage image;

    public void update() {}

    public void render(Graphics2D graphics2D) {}
}
