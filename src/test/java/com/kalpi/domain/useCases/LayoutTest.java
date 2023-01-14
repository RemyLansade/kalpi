package com.kalpi.domain.useCases;

import com.kalpi.domain.valueObject.Surface;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LayoutTest {

    @Test
    public void ShouldReturnASurface() {
        Surface testSurface = new Surface();
        Layout testLayout = new Layout(testSurface);
        assertEquals(testSurface.getCoordinates(), testLayout.getSurface());
    }

    @Test
    @DisplayName("Should return a default expansion")
    public void ShouldReturnADefaultExpansion() {
        Surface surface = new Surface();
        Layout testLayout = new Layout(surface);
        assertEquals(0, testLayout.getExpansion());
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an expansion gap of 1 for a rectangle")
    @Disabled
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForARectangle() {
        Surface surface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();
        Layout testLayout = new Layout(surface);
        testLayout.setExpansion(1);

        Surface surfaceWithExpansionGap = new Surface.Builder()
                .add(1,99)
                .add(199,99)
                .add(199,1)
                .add(1,1)
                .build();
        assertEquals(surfaceWithExpansionGap.getCoordinates(), testLayout.getSurfaceWithGap());
    }
}