package com.engine.util;

import com.game.Vector;

import java.awt.*;

public class VectorUtil {

    public static double calculateAngle(Point p1, Point p2) {
        int xDif = p2.x - p1.x;
        int yDif = p2.y - p1.y;
        return Math.atan2(yDif, xDif);
    }

    public static float magnitude(Vector vector) {
        double x = Math.pow(vector.x, 2);
        double y = Math.pow(vector.y, 2);
        return (float) Math.sqrt(x + y);
    }

    public static float calculateXVel(double angle, float maxSpeed) {
        double degrees = Math.toDegrees(angle);
        double xVel = maxSpeed * Math.cos(angle);
        int minAngle = 90;
        int maxAngle = 270;
        xVel = (angle >= minAngle && angle <= maxAngle) ? -1 * xVel : xVel;
        return (float) xVel;
    }

    public static float calculateYVel(double angle, float maxSpeed) {
        double yVel = maxSpeed * Math.sin(angle);
        double minAngle = 180;
        yVel = (angle >= minAngle) ? -1 * yVel :yVel;
        return (float) yVel;
    }
}
