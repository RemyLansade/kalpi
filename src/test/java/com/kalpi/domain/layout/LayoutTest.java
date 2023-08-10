package com.kalpi.domain.layout;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LayoutTest {

    @Test
    @DisplayName("Should return a surface")
    public void ShouldReturnASurface() {
        Surface testSurface = new Surface();
        Layout testLayout = new Layout(testSurface);
        assertEquals(testSurface, testLayout.getSurface());
    }

    @Test
    @DisplayName("Should add & return a surface with a peripheral gap")
    public void ShouldAddAndReturnASurfaceWithAPeripheralGap() throws Exception {
        Surface testSurface = new Surface.Builder()
                .add(0, 100)
                .add(100, 100)
                .add(100, 0)
                .add(0, 0)
                .build();

        Layout testLayout = new Layout(testSurface);
        testLayout.addPeripheralGap(1);

        Surface expectedSurface = new Surface.Builder()
                .add(1, 99)
                .add(99, 99)
                .add(99, 1)
                .add(1, 1)
                .build();

        assertEquals(expectedSurface, testLayout.getSurfaceWithPeripheralGap());
    }
}