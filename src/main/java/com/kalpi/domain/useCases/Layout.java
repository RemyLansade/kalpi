package com.kalpi.domain.useCases;

import com.kalpi.domain.valueObject.Surface;

import java.awt.geom.Point2D;
import java.util.HashMap;


public class Layout {

    Surface surface;
    int expansion = 0;

    public Layout(Surface surface) {
        this.surface = surface;
    }

    public HashMap<Integer, Point2D> getSurface() {
        return surface.getCoordinates();
    }

    public int getExpansion() {
        return expansion;
    }
}
