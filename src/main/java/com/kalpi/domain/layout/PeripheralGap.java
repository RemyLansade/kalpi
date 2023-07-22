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
    public HashMap<Integer, Point> compute() {
        if(size == DEFAULT_SIZE) {
            return coordinates;
        }
        HashMap<Integer, Point> peripheralGapCoordinates = new HashMap<>();

        peripheralGapCoordinates.put(0, new Point(coordinates.get(0).x + size, coordinates.get(0).y - size));
        peripheralGapCoordinates.put(1, new Point(coordinates.get(1).x - size, coordinates.get(1).y - size));
        peripheralGapCoordinates.put(2, new Point(coordinates.get(2).x - size, coordinates.get(2).y + size));
        peripheralGapCoordinates.put(3, new Point(coordinates.get(3).x + size, coordinates.get(3).y + size));

        return peripheralGapCoordinates;
    }
}
