package com.game.util;

import com.game.util.misc.Constants;
import lombok.Getter;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class InputMap extends HashMap<Character, Boolean> implements KeyListener, MouseListener, MouseMotionListener {

    @Getter
    private final Point cursor;
    @Getter
    private final Point click;

    {
        Constants.keySet.forEach(k -> put(k, false));
        cursor = new Point(-10, -10);
        click = new Point(-10, -10);
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
    public void mouseClicked(MouseEvent e) {
        click.setLocation(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursor.setLocation(e.getX(), e.getY());
    }

    // Unused
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
}
