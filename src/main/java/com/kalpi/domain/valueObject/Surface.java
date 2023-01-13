package com.kalpi.domain.valueObject;

import java.awt.geom.Point2D;
import java.util.HashMap;

public class Surface {

    private HashMap<Integer, Point2D> coordinates;

    public Surface() {
        this.coordinates = new HashMap<>();
    }

    public HashMap<Integer, Point2D> getCoordinates() {
        return this.coordinates;
    }
}
