package com.kalpi.domain.layout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    @DisplayName("Can calculate the three side of a triangle rectangle")
    public void CanCalculateTheThreeSideOfATriangleRectangle() {
        Point A = new Point(0,0);
        Point B = new Point(1,0);
        Point C = new Point(1,1);
        Triangle triangleTest = new Triangle(A,B,C);
        assertEquals(1, triangleTest.getLengthAB());
        assertEquals(1, triangleTest.getLengthBC());
        assertEquals(Math.sqrt(2), triangleTest.getLengthAC());
        B = new Point(2,0);
        C = new Point(2,2);
        Triangle triangleTest2 = new Triangle(A,B,C);
        assertEquals(2, triangleTest2.getLengthAB());
        assertEquals(2, triangleTest2.getLengthBC());
        assertEquals(Math.sqrt(8), triangleTest2.getLengthAC());
    }

    @Test
    @DisplayName("Can calculate the three angle of a triangle")
    public void CanCalculateTheThreeAngleOfATriangle() {
        Point A = new Point(0,0);
        Point B = new Point(1,0);
        Point C = new Point(1,1);
        Triangle triangleTest = new Triangle(A,B,C);
        assertEquals(45f, triangleTest.getAngleA());
        assertEquals(90f, triangleTest.getAngleB());
        assertEquals(45f, triangleTest.getAngleC());
    }
}