package com.kalpi.domain.layout;

import java.awt.Point;
import java.util.*;

public class Layout {

    private final Surface surface;
    // private int peripheralGapSize = 0;

    public Layout(Surface surface) {
        this.surface = surface;
    }

    public HashMap<Integer, Point> getSurface() {
        return surface.getCoordinates();
    }

    public HashMap<Integer, Point> getCoordinates() {
        return this.surface.getCoordinates();
    }
}
