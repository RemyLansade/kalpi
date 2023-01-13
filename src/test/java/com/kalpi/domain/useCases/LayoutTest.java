package com.kalpi.domain.useCases;

import com.kalpi.domain.valueObject.Surface;

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
    public void ShouldReturnAExpansion() {
        Layout testLayout = new Layout(new Surface());
        assertEquals(0, testLayout.getExpansion());
    }
}