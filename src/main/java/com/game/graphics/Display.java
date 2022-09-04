package com.game.graphics;

import com.game.Constants;
import com.game.Handler;
import com.game.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Map;

public class Display {

    JFrame frame;
    Canvas canvas;
    Renderer renderer;

    private Map<?, ?> map;

    public Display(Handler handler) {
        Dimension dimension = new Dimension(Constants.WIDTH, Constants.HEIGHT);

        canvas = new Canvas();
        canvas.setSize(dimension);
        canvas.setFocusable(false);

        frame = new JFrame();
        frame.addKeyListener(handler.getInputManager());
        frame.setSize(dimension);
        frame.add(canvas);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        canvas.createBufferStrategy(3);

        renderer = new Renderer();
        map = handler.getInputManager().keyMap;
    }

    public Graphics2D render() {
        return renderer.render();
    }

    public void show() {
        renderer.show();
    }

    class Renderer {

        Graphics2D g;
        BufferStrategy bufferStrategy;

        private Renderer() {}

        Graphics2D render() {
            bufferStrategy = canvas.getBufferStrategy();
            g = (Graphics2D) bufferStrategy.getDrawGraphics();

            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.setColor(Color.black);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            return g;
        }

        void show() {
            g.setColor(Color.white);
            g.drawRect(0, 0, canvas.getWidth()-1, canvas.getHeight()-1);
            bufferStrategy.show();
            g.dispose();
        }
    }
}
