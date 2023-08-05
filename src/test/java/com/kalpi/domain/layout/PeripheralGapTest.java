package com.kalpi.domain.layout;

import com.kalpi.exception.SameDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeripheralGapTest {

    @Test
    @DisplayName("Can take a surface and a size")
    public void CanTakeCoordinatesAndASize() throws NoSuchFieldException {
        Surface testSurface = new Surface();
        PeripheralGap peripheralGap = new PeripheralGap(testSurface);
        String expectedSurfaceField = peripheralGap.getClass().getDeclaredField("coordinates").getName();
        String expectedSizeField = peripheralGap.getClass().getDeclaredField("size").getName();
        assertEquals("coordinates", expectedSurfaceField);
        assertEquals("size", expectedSizeField);
    }

    @Test
    @DisplayName("Must have a default size of 0")
    public void MustHaveADefaultSizeOfZero() {
        Surface testSurface = new Surface();
        assertEquals(PeripheralGap.DEFAULT_SIZE, new PeripheralGap(testSurface).getSize());
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
    @DisplayName("Must return the surface to be laid out with an null peripheral gap for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnNullPeripheralGapForARectangle() throws SameDirectionException {
        Surface testSurface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 0);

        Surface expectedOutput = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        assertEquals(expectedOutput.getCoordinates(), peripheralGap.compute());
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 1 for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForARectangle() throws SameDirectionException {
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

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 2 for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOfTwoForARectangle() throws SameDirectionException {
        Surface testSurface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 2);

        Surface expectedOutput = new Surface.Builder()
                .add(2,98)
                .add(198,98)
                .add(198,2)
                .add(2,2)
                .build();

        assertEquals(expectedOutput.getCoordinates(), peripheralGap.compute());
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 1 for a surface with multiple points and only right angles")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForASurfaceWithMultiplePointsAndOnlyRightAngles() throws SameDirectionException {
        Surface testSurface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(100,0)
                .add(100,50)
                .add(0,50)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 1);

        Surface expectedOutput = new Surface.Builder()
                .add(1,99)
                .add(199,99)
                .add(199,1)
                .add(101,1)
                .add(101,51)
                .add(1,51)
                .build();

        assertEquals(expectedOutput.getCoordinates(), peripheralGap.compute());
    }
}