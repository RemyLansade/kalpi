package com.kalpi.domain.layout;

import java.awt.*;

public class Triangle {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private double AB;
    private double AC;
    private double BC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.AB = getLengthAB();
        this.AC = getLengthAC();
        this.BC = getLengthBC();
    }

    public double getAngleA() {
        double angleInRad =  Math.acos((Math.pow(AB, 2) + Math.pow(AC, 2) - Math.pow(BC, 2)) / (2 * AB * AC));
        return Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    public double getAngleB() {
        double angleInRad = Math.acos((Math.pow(AB, 2) + Math.pow(BC, 2) - Math.pow(AC, 2)) / (2 * AB * BC));
        return Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    public double getAngleC() {
        double angleInRad = Math.acos((Math.pow(AC, 2) + Math.pow(BC, 2) - Math.pow(AB, 2)) / (2 * AC * BC));
        return Math.round(((angleInRad * 180) / Math.PI) * 100) / 100;
    }

    public double getLengthAB() {
        return Math.sqrt(Math.pow((pointB.x - pointA.x), 2) + Math.pow((pointB.y - pointA.y), 2));
    }

    public double getLengthAC() {
        return Math.sqrt(Math.pow((pointC.x - pointA.x), 2) + Math.pow((pointC.y - pointA.y), 2));
    }

    public double getLengthBC() {
        return Math.sqrt(Math.pow((pointC.x - pointB.x), 2) + Math.pow((pointC.y - pointB.y), 2));
    }
}
