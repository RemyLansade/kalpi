package com.kalpi.domain.useCases;

import com.kalpi.domain.valueObject.Surface;

import java.awt.Point;
import java.util.HashMap;

public class Layout {

    private final Surface surface;
    private int expansion = 0;

    public Layout(Surface surface) {
        this.surface = surface;
    }

    public HashMap<Integer, Point> getSurface() {
        return surface.getCoordinates();
    }

    public HashMap<Integer, Point> getSurfaceWithGap() {
        return null;
    }

    public int getExpansion() {
        return this.expansion;
    }

    public void setExpansion(int size) {
        this.expansion = size;
    }
}
