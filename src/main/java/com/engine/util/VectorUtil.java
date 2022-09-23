package com.engine.util;

import com.game.Vector;

import java.awt.*;

public class VectorUtil {

    public static double calculateAngle(Point p1, Point p2) {
        int xDif = p1.x - p2.x;
        int yDif = p1.y - p2.y;
        return Math.atan2(yDif, xDif) - Math.PI / 2;
    }

    public static float magnitude(Vector vector) {
        double x = Math.pow(vector.x, 2);
        double y = Math.pow(vector.y, 2);
        return (float) Math.sqrt(x + y);
    }

    public static float calculateXVel(double angle, float maxSpeed) {
        double xVel = maxSpeed*Math.cos(angle);
        xVel = (angle >= Math.PI / 2.0 && angle <= 3 * Math.PI / 2.0) ? -1 * xVel : xVel;
        return (float) xVel;
    }

    public static float calculateYVel(double angle, float maxSpeed) {
        double yVel = maxSpeed*Math.sin(angle);
        yVel = (angle >= 0 && angle <= Math.PI) ? -1 * yVel : yVel;
        return (float) yVel;
    }
}
