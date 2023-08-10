package com.kalpi.domain.layout;

import java.util.HashMap;

public class Surface {

    private final HashMap<Integer, Point> coordinates;

    public Surface() {
        this.coordinates = new HashMap<>();
    }

    public static class Builder {
        Surface surface = new Surface();

        public Builder add(double x, double y) {
            surface.addCoordinate(x,y);
            return this;
        }

        public Surface build() {
            return surface;
        }
    }

    public void addCoordinate(double x, double y) {
        this.coordinates.put(this.coordinates.size(), new Point(x,y));
    }

    public HashMap<Integer, Point> getCoordinates() {
        return this.coordinates;
    }

    public boolean isValid() {
        return this.coordinates.size() > 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Surface surface)) return false;
        return this.coordinates.equals(surface.coordinates);
    }
}
