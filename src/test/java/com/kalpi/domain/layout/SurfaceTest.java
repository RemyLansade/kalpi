package com.kalpi.domain.layout;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SurfaceTest {

    @Test
    @DisplayName("Must be return a empty map")
    public void MustBeReturnAEmptyMap() {
        Surface testSurface = new Surface();
        assertEquals(new HashMap<Integer,Point>(), testSurface.getCoordinates());
    }

    @Test
    @DisplayName("Must be build")
    public void MustBeBuild() {
        Surface surface = new Surface.Builder()
                .add(0,0)
                .add(1,1)
                .build();
        assertEquals(2, surface.getCoordinates().size());
        assertEquals(new Point(), surface.getCoordinates().get(0));
        assertEquals(new Point(1, 1), surface.getCoordinates().get(1));
    }

    @Test
    @DisplayName("Should be valid")
    public void ShouldBeValid() {
        Surface surface = new Surface.Builder()
                .add(0,0)
                .add(1,1)
                .build();
        assertFalse(surface.isValid());
        surface.addCoordinate(2,2);
        assertTrue(surface.isValid());
    }
}
