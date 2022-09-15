package com.engine.abstracts.state;

import java.awt.*;

public class StateManager {

    State activeState;

    public StateManager() {
        activeState = States.MENU.state;
    }

    public void update() {
        activeState.update();
    }

    public void render(Graphics2D g) {
        activeState.render(g);
    }

    public void setActiveState(States scene) {
        activeState = scene.state;
    }
}
