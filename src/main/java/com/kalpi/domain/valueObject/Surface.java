package com.kalpi.domain.valueObject;

import java.awt.Point;
import java.util.HashMap;

public class Surface {

    private HashMap<Integer, Point> coordinates;

    public Surface() {
        this.coordinates = new HashMap<>();
    }

    public static class Builder {
        Surface surface = new Surface();

        public Builder add(int x, int y) {
            surface.addCoordinate(x,y);
            return this;
        }

        public Surface build() {
            return surface;
        }
    }

    private void addCoordinate(int x, int y) {
        this.coordinates.put(this.coordinates.size(), new Point(x,y));
    }

    public HashMap<Integer, Point> getCoordinates() {
        return this.coordinates;
    }
}
