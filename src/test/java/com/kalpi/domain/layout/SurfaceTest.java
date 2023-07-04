package com.kalpi.domain.layout;

import java.awt.Point;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceTest {

    @Test
    public void MustBeReturnAEmptyMap() {
        Surface testSurface = new Surface();
        assertEquals(new HashMap<Integer,Point>(), testSurface.getCoordinates());
    }

    @Test
    public void MustBeBuild() {
        Surface surface = new Surface.Builder()
                .add(0,0)
                .add(1,1)
                .build();
        assertEquals(2, surface.getCoordinates().size());
        assertEquals(new Point(), surface.getCoordinates().get(0));
        assertEquals(new Point(1,1), surface.getCoordinates().get(1));
    }
}
