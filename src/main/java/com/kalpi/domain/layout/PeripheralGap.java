package com.kalpi.domain.layout;

import java.awt.Point;
import java.util.HashMap;

public class PeripheralGap {
    private int size;
    private Surface surface;

    public PeripheralGap(Surface surface) {
        this(surface, 0);
    }

    public PeripheralGap(Surface surface, int size) {
        this.surface = surface;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public HashMap<Integer, Point> compute() {
        return new Surface.Builder()
                .add(1,99)
                .add(199,99)
                .add(199,1)
                .add(1,1)
                .build()
                .getCoordinates();
    }
}
