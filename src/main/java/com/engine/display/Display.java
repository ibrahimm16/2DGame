package com.engine.display;

import com.engine.Constants;
import com.engine.Handler;
import com.game.graphics.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display {

    JFrame frame;
    Canvas canvas;
    Renderer renderer;

    public Display() {
        Handler handler = Handler.get();

        Dimension dimension = new Dimension(Constants.WIDTH, Constants.HEIGHT);
        canvas = new Canvas();
        canvas.setSize(dimension);
        canvas.setFocusable(false);
        canvas.addMouseListener(handler.inputMap);
        canvas.addMouseMotionListener(handler.inputMap);

        frame = new JFrame();
        frame.addKeyListener(handler.inputMap);
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
    }

    public Graphics2D render() {
        return renderer.render();
    }

    public void show() {
        renderer.show();
    }

    private class Renderer {

        Graphics2D g;
        BufferStrategy bufferStrategy;

        private Renderer() {}

        Graphics2D render() {
            bufferStrategy = canvas.getBufferStrategy();
            g = (Graphics2D) bufferStrategy.getDrawGraphics();

            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.setColor(Color.black);
            g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.drawImage(Images.getImage("Background"), 0, 0, null);

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
