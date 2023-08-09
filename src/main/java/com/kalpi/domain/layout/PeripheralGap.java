package com.kalpi.domain.layout;

import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;

public class PeripheralGap {
    public static final int DEFAULT_SIZE = 0;
    private final int size;
    private final HashMap<Integer, Point> coordinates;

    public PeripheralGap(Surface surface) {
        this(surface, DEFAULT_SIZE);
    }

    public PeripheralGap(Surface surface, int size) {
        this.coordinates = surface.getCoordinates();
        this.size = size;
    }

    /**
     * Get the size of the peripheral gap
     * @return int size
     */
    public int getSize() {
        return size;
    }

    /**
     * Calculate the peripheral gap coordinates
     * @return HashMap<Integer, Point> coordinates
     */
    public HashMap<Integer, Point> compute() throws Exception {
        if(size == DEFAULT_SIZE) {
            return coordinates;
        }

        HashMap<Integer, Point> peripheralGapCoordinates = new HashMap<>();

        for (int i = 0; i < coordinates.size(); i++) {
            Point currentPoint = coordinates.get(i);
            Point previousPoint = i == 0 ?
                    coordinates.get(coordinates.size() - 1) :
                    coordinates.get(i - 1);
            Point nextPoint = i == coordinates.size() - 1 ?
                    coordinates.get(0) :
                    coordinates.get(i + 1);
            double peripheralGapAngle = getPeripheralGapAngle(currentPoint, previousPoint, nextPoint);
            System.out.println(peripheralGapAngle);
            addingPeripheralGapCoordinates(i, peripheralGapCoordinates, peripheralGapAngle);
        }

        return peripheralGapCoordinates;
    }

    /**
     * Calculate the peripheral gap angle given the current point, the previous point and the next point
     * @param currentPoint
     * @param previousPoint
     * @param nextPoint
     * @throws InvalidAlgorithmParameterException
     * @return double peripheralGapAngle
     */
    private double getPeripheralGapAngle(Point currentPoint, Point previousPoint, Point nextPoint) throws InvalidAlgorithmParameterException {
        double previousAngle = new Vector2D(currentPoint, previousPoint).getAngle();
        double nextAngle = new Vector2D(currentPoint, nextPoint).getAngle();
        double peripheralGapAngle;
        Direction direction = new Vector2D(previousPoint, currentPoint).getDirection(new Vector2D(currentPoint, nextPoint));
        if(direction == Direction.STRAIGHT) {
            throw new InvalidAlgorithmParameterException("The surface cannot have two consecutive points in the same direction");
        }
        if (direction == Direction.RIGHT && previousAngle > nextAngle) {
            nextAngle += 360;
        } else if (direction == Direction.LEFT && nextAngle > previousAngle) {
            previousAngle += 360;
        }
        peripheralGapAngle = (previousAngle + nextAngle) / 2 ;
        if(direction == Direction.LEFT) {
            if(peripheralGapAngle < 180) {
                peripheralGapAngle += 180;
            }
            peripheralGapAngle -= 180;
        }
        return peripheralGapAngle;
    }

    /**
     * Add the peripheral gap coordinates to the HashMap
     * @param peripheralGapAngle
     * @param peripheralGapCoordinates
     * @param i
     * @throws InvalidAlgorithmParameterException
     */
    private void addingPeripheralGapCoordinates(int i, HashMap<Integer, Point> peripheralGapCoordinates, double peripheralGapAngle) throws InvalidAlgorithmParameterException {
        if(peripheralGapAngle > 360 || peripheralGapAngle < 0) {
            throw new InvalidAlgorithmParameterException("Invalid angle");
        }
        double newX;
        double newY;
        if (peripheralGapAngle <= 90) {
            newX = coordinates.get(i).getX() + getOppositeSideLength(size, peripheralGapAngle);
            newY = coordinates.get(i).getY() + size;
        } else if (peripheralGapAngle <= 180) {
            newX = coordinates.get(i).getX() - getOppositeSideLength(size, peripheralGapAngle - 90);
            newY = coordinates.get(i).getY() + size;
        } else if (peripheralGapAngle <= 270) {
            newX = coordinates.get(i).getX() - getOppositeSideLength(size, peripheralGapAngle - 180);
            newY = coordinates.get(i).getY() - size;
        } else {
            newX = coordinates.get(i).getX() + getOppositeSideLength(size, peripheralGapAngle - 270);
            newY = coordinates.get(i).getY() - size;
        }
        peripheralGapCoordinates.put(i, new Point(newX, newY));
    }

    /**
     * Can calculate the rectangular triangle opposite side length given the adjacent side length and the angle
     * @param adjacentSideLength
     * @param angleInDegrees
     * @return double oppositeSideLength
     */
    private double getOppositeSideLength(int adjacentSideLength, double angleInDegrees) throws InvalidAlgorithmParameterException {
        if(angleInDegrees <= 0 || angleInDegrees >= 90) {
            throw new InvalidAlgorithmParameterException("The angle must be between 0 and 90 degrees");
        }
        return Math.round(adjacentSideLength / Math.tan(Math.toRadians(angleInDegrees)) * 10_000.0) / 10_000.0;
    }
}
