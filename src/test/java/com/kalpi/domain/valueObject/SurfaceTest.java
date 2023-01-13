package com.kalpi.domain.valueObject;

import java.awt.geom.Point2D;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceTest {

    @Test
    public void MustBeReturnAMap() {
        Surface testSurface = new Surface();
        assertEquals(new HashMap<Integer, Point2D>(), testSurface.getCoordinates());
    }
}
