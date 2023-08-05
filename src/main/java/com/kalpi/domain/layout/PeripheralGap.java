package com.kalpi.domain.layout;

import com.kalpi.exception.SameDirectionException;

import java.awt.Point;
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
    public HashMap<Integer, Point> compute() throws SameDirectionException {
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

            double previousAngle = new Vector2D(currentPoint, previousPoint).getAngle();
            double nextAngle = new Vector2D(currentPoint, nextPoint).getAngle();
            double peripheralGapAngle;

            Direction direction = new Vector2D(previousPoint, currentPoint).getDirection(new Vector2D(currentPoint, nextPoint));

            switch (direction) {
                case RIGHT -> {
                    if(previousAngle > nextAngle) {
                        nextAngle += 360;
                    }
                }
                case LEFT -> {
                    if(nextAngle > previousAngle) {
                        previousAngle += 360;
                    }
                }
                case STRAIGHT -> throw new SameDirectionException();
            }

            peripheralGapAngle = (previousAngle + nextAngle) / 2 ;

            if(direction == Direction.LEFT) {
                if(peripheralGapAngle < 180) {
                    peripheralGapAngle += 180;
                }
                peripheralGapAngle -= 180;
            }

            if(peripheralGapAngle > 0 && peripheralGapAngle <= 90) {
                peripheralGapCoordinates.put(i, new Point(coordinates.get(i).x + size, coordinates.get(i).y + size));

            } else if (peripheralGapAngle > 90 && peripheralGapAngle <= 180) {
                peripheralGapCoordinates.put(i, new Point(coordinates.get(i).x - size, coordinates.get(i).y + size));

            } else if (peripheralGapAngle > 180 && peripheralGapAngle <= 270) {
                peripheralGapCoordinates.put(i, new Point(coordinates.get(i).x - size, coordinates.get(i).y - size));

            } else if(peripheralGapAngle > 270 && peripheralGapAngle <= 360) {
                peripheralGapCoordinates.put(i, new Point(coordinates.get(i).x + size, coordinates.get(i).y - size));
            } else {
                throw new RuntimeException("Invalid angle");
            }
        }

        return peripheralGapCoordinates;
    }
}
