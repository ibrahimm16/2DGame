package com.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class InputManager implements KeyListener {

    public Map<Character, Boolean> keyMap = new HashMap<>();

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0) System.exit(0);

        keyMap.put(e.getKeyChar(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyMap.put(e.getKeyChar(), false);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
