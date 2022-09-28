package com.engine.abstracts.state;

import com.game.states.GameState;
import com.game.states.MenuState;

public enum States {

    MENU(new MenuState()), GAME(new GameState());

    public final State state;

    States(State state) {
        this.state = state;
    }
}
