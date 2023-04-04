package com.engine.abstracts.state;

import com.game.states.GameState;
import com.game.states.MenuState;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StateManager {

    private final Map<String, State> states;
    private String activeState;

    public StateManager() {
        activeState = States.MENU;
        states = new HashMap<>();
        states.put(States.MENU, new MenuState());
        states.put(States.GAME, new GameState());
    }

    public void update() {
        states.get(activeState).update();
    }

    public void render(Graphics2D g) {
        states.get(activeState).render(g);
    }

    public void setActiveState(String state) {
        states.get(activeState).active = false;
        states.get(state).active = true;
        activeState = state;
    }
}
