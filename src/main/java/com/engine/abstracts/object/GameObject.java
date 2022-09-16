package com.engine.abstracts.object;

import com.engine.Handler;
import com.engine.util.Timer;
import com.game.graphics.Images;
import com.engine.util.GameList;
import com.engine.util.InputMap;
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
    public Timer timer;
    public Boolean active;
    public Boolean removable;

    public GameObject() {
        handler = Handler.handler;
        active = true;
        removable = false;
        timer = new Timer();
        objects = new GameList<>();
        inputMap = handler.inputMap;
        String imageKey = this.getClass().getSimpleName();
        image = Images.getImage(imageKey);
    }

    public void deserialize() {
        handler = Handler.handler;
        active = true;
        removable = false;
        objects = new GameList<>();
        inputMap = handler.inputMap;
        String imageKey = this.getClass().getSimpleName();
        image = Images.getImage(imageKey);
    }

    public void update() {
        objects.update();
        timer.update();
    }

    public void render(Graphics2D g) {
        objects.render(g);
    }

    public void fireEvent(Runnable event) {
        if (event != null) event.run();
    }

    public void fireTimedEvent(String timerName, Runnable event) {
        if (timer.canFire(timerName)) {
            event.run();
            timer.reset(timerName);
        }
    }
}
