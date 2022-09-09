package com.game.util;

import com.game.util.misc.Constants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyMap extends HashMap<Character, Boolean> implements KeyListener {

    {
        // Iterate through the valid game keys and default them to false in this map to avoid null issues
        Constants.keySet.forEach(k -> put(k, false));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = Character.toLowerCase(e.getKeyChar());

        if (!Constants.keySet.contains(key)) return;
        if (key == '0') System.exit(0);

        put(key, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = Character.toLowerCase(e.getKeyChar());

        if (!Constants.keySet.contains(key)) return;

        put(key, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
