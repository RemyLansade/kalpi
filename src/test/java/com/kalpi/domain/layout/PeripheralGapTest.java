package com.kalpi.domain.layout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeripheralGapTest {

    @Test
    @DisplayName("Can take a surface and a size")
    public void CanTakeASurfaceAndASize() throws NoSuchFieldException {
        Surface testSurface = new Surface();
        PeripheralGap peripheralGap = new PeripheralGap(testSurface);
        String expectedSurfaceField = peripheralGap.getClass().getDeclaredField("surface").getName();
        String expectedSizeField = peripheralGap.getClass().getDeclaredField("size").getName();
        assertEquals("surface", expectedSurfaceField);
        assertEquals("size", expectedSizeField);
    }

    @Test
    @DisplayName("Must have a initialize size of 0")
    public void MustHaveAInitializeSizeOfZero() {
        Surface testSurface = new Surface();
        assertEquals(0, new PeripheralGap(testSurface).getSize());
    }

    @Test
    @DisplayName("Can change the size to 1")
    public void MustHaveAInitializeSizeOfOne() {
        Surface testSurface = new Surface();
        PeripheralGap peripheralGap = new PeripheralGap(testSurface,1);
        assertEquals(1, peripheralGap.getSize());
    }


    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 1 for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForARectangle() {
        Surface testSurface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 1);

        Surface expectedOutput = new Surface.Builder()
                .add(1,99)
                .add(199,99)
                .add(199,1)
                .add(1,1)
                .build();

        assertEquals(expectedOutput.getCoordinates(), peripheralGap.compute());
    }
}