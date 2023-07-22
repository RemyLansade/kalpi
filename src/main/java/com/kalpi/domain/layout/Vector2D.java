package com.kalpi.domain.layout;

import java.awt.Point;

enum Direction {
    LEFT, RIGHT, STRAIGHT
}

class Vector2D {
    Point p1;
    Point p2;

    public Vector2D(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Returns the angle of the vector2D in degrees. The angle is measured from the positive x-axis.
     * @return double
     */
    public double getAngle() {
        double angle = Math.toDegrees(Math.atan2(p2.getY() - p1.getY(), p2.getX() - p1.getX()));
        if(angle < 0){
            angle += 360;
        }
        return angle;
    }

    /**
     * Returns the direction of the next Vector2D relative to the current vector2D.
     * @param nextVector2D Vector2D
     * @return Direction
     */
    public Direction getDirection(Vector2D nextVector2D) {
        double nextAngle =
                nextVector2D.getAngle() - this.getAngle() <= 0 ?
                        nextVector2D.getAngle() - this.getAngle() + 360 :
                        nextVector2D.getAngle() - this.getAngle();
        if(nextAngle == 180){
            return Direction.STRAIGHT;
        }
        if(nextAngle < 180){
            return Direction.LEFT;
        }
        return Direction.RIGHT;
    }
}