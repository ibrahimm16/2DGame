package com.game.states;

import com.game.entities.Carl;
import com.game.entities.player.Player;
import com.engine.abstracts.state.State;

import java.awt.*;

public class GameState extends State {

    public GameState() {
        objects.add(new Player());
        objects.add(new Carl());
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }
}
