package com.game.states;

import com.engine.abstracts.state.State;
import com.engine.abstracts.state.States;

import java.awt.*;

public class MenuState extends State {

    @Override
    public void update() {
        if (new Rectangle(200, 200, 200, 200).contains(inputMap.getClick())) {
            handler.stateManager.setActiveState(States.GAME);
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(200, 200, 200, 200);
    }
}
