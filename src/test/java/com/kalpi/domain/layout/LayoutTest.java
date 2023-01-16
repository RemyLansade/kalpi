package com.kalpi.domain.layout;

import com.kalpi.domain.layout.Layout;
import com.kalpi.domain.layout.Surface;

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

}