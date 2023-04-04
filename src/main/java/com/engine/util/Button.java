package com.engine.util;

import com.game.graphics.Images;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {

    private final Runnable runnable;
    private final Rectangle boundingBox;
    private BufferedImage image;

    public Button(Runnable runnable, int x, int y, int width, int height) {
        this.runnable = runnable;
        boundingBox = new Rectangle(x, y, width, height);
    }

    public Button(Runnable runnable, int x, int y, String name) {
        this.runnable = runnable;
        image = Images.getImage(name);
        boundingBox = new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    public void render(Graphics2D g) {
        if (image != null) {
            g.drawImage(image, boundingBox.x, boundingBox.y, null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        }
    }

    public boolean isClicked(InputMap inputMap) {
        Point point = inputMap.getClick();
        return boundingBox.contains(point.x, point.y);
    }

    public void fireEvent() {
        runnable.run();
    }

    public void setLocation(int x, int y, int width, int height) {
        boundingBox.setLocation(x, y);
        boundingBox.setSize(width, height);
    }

    public void setLocation(int x, int y) {
        boundingBox.setLocation(x, y);
        boundingBox.setSize(image.getWidth(), image.getHeight());
    }
}
