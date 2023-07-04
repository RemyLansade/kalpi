package com.kalpi.domain.layout;

import java.awt.Point;
import java.util.HashMap;

public class PeripheralGap {
    public static final int DEFAULT_SIZE = 0;
    private int size;
    private final HashMap<Integer, Point> coordinates;

    public PeripheralGap(Surface surface) {
        this(surface, DEFAULT_SIZE);
    }

    public PeripheralGap(Surface surface, int size) {
        this.coordinates = surface.getCoordinates();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public HashMap<Integer, Point> compute() {
        if(size == DEFAULT_SIZE) {
            return coordinates;
        }
        HashMap<Integer, Point> peripheralGapCoordinates = new HashMap<>();
        for (int i = 0; i < coordinates.size(); i++) {
            Point currentPoint = coordinates.get(i);
            Point previousPoint = i == 0 ?
                    coordinates.get(coordinates.size() - 1):
                    coordinates.get(i - 1);
            Point nextPoint = i == coordinates.size() - 1 ?
                    coordinates.get(0):
                    coordinates.get(i + 1);
            Triangle triangle = new Triangle(currentPoint, nextPoint, previousPoint);

            int currentX = currentPoint.x - (int) (triangle.getLengthAB() / Math.tan(triangle.getAngleA()));
            int currentY = currentPoint.y - size;

            peripheralGapCoordinates.put(i, new Point(currentX,currentY));
        }

        return peripheralGapCoordinates;
    }
}
