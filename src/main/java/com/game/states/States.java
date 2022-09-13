package com.game.states;

import com.game.util.abstracts.State;

public enum States {

    MENU(new MenuState()), GAME(new GameState());

    public final State state;

    States(State state) {
        this.state = state;
    }
}
