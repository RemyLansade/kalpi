package com.kalpi.domain.layout;

import java.awt.*;

public class Triangle {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final double AB;
    private final double AC;
    private final double BC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.AB = getLengthAB();
        this.AC = getLengthAC();
        this.BC = getLengthBC();
    }

    /**
     * Get the angle A
     * @return double angle
     */
    public double getAngleA() {
        double angleInRad =  Math.acos((Math.pow(AB, 2) + Math.pow(AC, 2) - Math.pow(BC, 2)) / (2 * AB * AC));
        return (double) Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    /**
     * Get the angle B
     * @return double angle
     */
    public double getAngleB() {
        double angleInRad = Math.acos((Math.pow(AB, 2) + Math.pow(BC, 2) - Math.pow(AC, 2)) / (2 * AB * BC));
        return (double) Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    /**
     * Get the angle C
     * @return double angle
     */
    public double getAngleC() {
        double angleInRad = Math.acos((Math.pow(AC, 2) + Math.pow(BC, 2) - Math.pow(AB, 2)) / (2 * AC * BC));
        return (double) Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    /**
     * Get the length of the side AB
     * @return double length
     */
    public double getLengthAB() {
        return Math.sqrt(Math.pow((pointB.x - pointA.x), 2) + Math.pow((pointB.y - pointA.y), 2));
    }

    /**
     * Get the length of the side AC
     * @return double length
     */
    public double getLengthAC() {
        return Math.sqrt(Math.pow((pointC.x - pointA.x), 2) + Math.pow((pointC.y - pointA.y), 2));
    }

    /**
     * Get the length of the side BC
     * @return double length
     */
    public double getLengthBC() {
        return Math.sqrt(Math.pow((pointC.x - pointB.x), 2) + Math.pow((pointC.y - pointB.y), 2));
    }
}
