package com.kalpi.domain.layout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;

class Vector2DTest {
    @Test
    @DisplayName("Can return the angle of a vector2D with positive coordinates")
    void CanReturnTheAngleOfAVector2DWithPositiveCoordinates() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 1);
        Point p4 = new Point(1, 0);
        Point p5 = new Point(1, 2);
        Point p6 = new Point(2, 1);
        Vector2D v = new Vector2D(p1, p2);
        Vector2D v2 = new Vector2D(p1, p3);
        Vector2D v3 = new Vector2D(p1, p4);
        Vector2D v4 = new Vector2D(p1, p5);
        Vector2D v5 = new Vector2D(p1, p6);
        assertEquals(45, v.getAngle());
        assertEquals(90, v2.getAngle());
        assertEquals(0, v3.getAngle());
        assertEquals(63.43494882292201, v4.getAngle());
        assertEquals(26.56505117707799, v5.getAngle());
    }

    @Test
    @DisplayName("Can return the angle of a vector2D with negative coordinates")
    void CanGetTheAngleOfAVector2DWithNegativeCoordinates() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, -1);
        Point p3 = new Point(0, -1);
        Point p4 = new Point(-1, 0);
        Point p5 = new Point(0, 1);
        Vector2D v = new Vector2D(p1, p2);
        Vector2D v2 = new Vector2D(p1, p3);
        Vector2D v3 = new Vector2D(p1, p4);
        Vector2D v4 = new Vector2D(p1, p5);
        assertEquals(225, v.getAngle());
        assertEquals(270, v2.getAngle());
        assertEquals(180, v3.getAngle());
        assertEquals(90, v4.getAngle());
    }

    @Test
    @DisplayName("Can return the angle of a vector2D with mixed coordinates")
    void CanGetTheAngleOfAVector2DWithMixedCoordinates() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-1, 1);
        Point p3 = new Point(1, -1);
        Point p4 = new Point(-1, -1);
        Vector2D v = new Vector2D(p1, p2);
        Vector2D v2 = new Vector2D(p1, p3);
        Vector2D v3 = new Vector2D(p1, p4);
        assertEquals(135, v.getAngle());
        assertEquals(315, v2.getAngle());
        assertEquals(225, v3.getAngle());
    }

    @Test
    @DisplayName("Can return the angle of a vector2D with the same coordinates")
    void CanGetTheAngleOfAVector2DWithTheSameCoordinates() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Vector2D v = new Vector2D(p1, p2);
        assertEquals(0, v.getAngle());
    }

    @Test
    @DisplayName("Can get the right direction of the next vector2D")
    void CanGetTheRightDirectionOfTheNextVector2D() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(1, 0);
        Vector2D v1 = new Vector2D(p1, p2);
        Vector2D v2 = new Vector2D(p2, p3);
        Vector2D v3 = new Vector2D(p3, p4);
        Vector2D v4 = new Vector2D(p4, p1);
        assertEquals(Direction.RIGHT, v1.getDirection(v2));
        assertEquals(Direction.RIGHT, v2.getDirection(v3));
        assertEquals(Direction.RIGHT, v3.getDirection(v4));
        assertEquals(Direction.RIGHT, v4.getDirection(v1));
    }

    @Test
    @DisplayName("Can get the left direction of the next vector2D")
    void CanGetTheLeftDirectionOfTheNextVector2D() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Point p4 = new Point(1, 0);
        Vector2D v1 = new Vector2D(p2, p1);
        Vector2D v2 = new Vector2D(p1, p4);
        Vector2D v3 = new Vector2D(p4, p3);
        Vector2D v4 = new Vector2D(p3, p2);
        assertEquals(Direction.LEFT, v1.getDirection(v2));
        assertEquals(Direction.LEFT, v2.getDirection(v3));
        assertEquals(Direction.LEFT, v3.getDirection(v4));
        assertEquals(Direction.LEFT, v4.getDirection(v1));
    }

    @Test
    @DisplayName("Can get the straight direction of the next vector2D")
    void CanGetTheStraightDirectionOfTheNextVector2D() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(1, 1);
        Vector2D v1 = new Vector2D(p1, p2);
        Vector2D v2 = new Vector2D(p2, p1);
        Vector2D v3 = new Vector2D(p2, p3);
        Vector2D v4 = new Vector2D(p3, p2);
        assertEquals(Direction.STRAIGHT, v1.getDirection(v2));
        assertEquals(Direction.STRAIGHT, v2.getDirection(v1));
        assertEquals(Direction.STRAIGHT, v3.getDirection(v4));
        assertEquals(Direction.STRAIGHT, v4.getDirection(v3));
    }
}