package com.kalpi.domain.layout;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LayoutTest {

    @Test
    public void ShouldReturnASurface() {
        Surface testSurface = new Surface();
        Layout testLayout = new Layout(testSurface);
        assertEquals(testSurface.getCoordinates(), testLayout.getSurface());
    }
}