package com.game.states;

import com.engine.abstracts.state.State;
import com.engine.abstracts.state.States;
import com.engine.util.Button;

public class MenuState extends State {

    private final String GAME_START = "START_GAME";

    public MenuState() {
        super();
        active = true;
        setButtons();
    }

    @Override
    public void setButtons() {
        Button startButton = new Button(() -> {
            handler.stateManager.setActiveState(States.GAME);
        }, 200, 200, 300, 200);

        buttons.put(GAME_START, startButton);
    }
}
