package com.engine.abstracts.object;

import com.engine.Handler;
import com.game.graphics.Images;
import com.engine.util.GameList;
import com.engine.util.InputMap;
import com.engine.util.TimeUtil;
import lombok.Data;
import lombok.ToString;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

@Data
@ToString(exclude = {"handler", "image", "inputMap"})
public abstract class GameObject implements Serializable {


    public transient Handler handler;
    public transient GameList<GameObject> objects;
    public transient BufferedImage image;
    public transient InputMap inputMap;
    public Integer ticks;
    public Boolean active;
    public Boolean removable;


    public GameObject() {
        init();
    }

    public void init() {
        handler = Handler.handler;
        active = true;
        removable = false;
        ticks = 0;
        objects = new GameList<>();
        inputMap = handler.inputMap;
        String imageKey = this.getClass().getSimpleName();
        image = Images.getImage(imageKey);
    }

    public void update() {
        objects.update();
        ticks++;
    }

    public void render(Graphics2D g) {
        objects.render(g);
    }

    public void fireEvent(Runnable event) {
        if (event != null) event.run();
    }

    public void fireTimedEvent(int milliseconds, Runnable event) {
        if (TimeUtil.hasElapsed(milliseconds, ticks) && event != null) {
            event.run();
        }
    }

    public void nullCheckEvent(GameObject object, Runnable event) {
        if (object != null && event != null) event.run();
    }
}
