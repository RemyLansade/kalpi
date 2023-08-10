package com.kalpi.domain.layout;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

class PeripheralGapTest {

    public static PeripheralGap peripheralGap;

    private Method getOppositeSideLengthMethod() {
        Method[] peripheralGapMethods = PeripheralGap.class.getDeclaredMethods();
        for (Method method : peripheralGapMethods) {
            if (method.getName().equals("getOppositeSideLength")) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    @BeforeAll
    public static void setUp() {
        peripheralGap = new PeripheralGap(new Surface());
    }

    @Test
    @DisplayName("Can take a surface and a size")
    public void CanTakeCoordinatesAndASize() throws NoSuchFieldException {
        Surface testSurface = new Surface();
        PeripheralGap peripheralGap = new PeripheralGap(testSurface);
        String expectedSurfaceField = peripheralGap.getClass().getDeclaredField("surface").getName();
        String expectedSizeField = peripheralGap.getClass().getDeclaredField("size").getName();
        assertEquals("surface", expectedSurfaceField);
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
    @DisplayName("Must calculate the opposite side of a right triangle")
    public void MustCalculateTheOppositeSideOfARightTriangle() throws Exception {
        try {
            assertEquals(2.4142, Objects.requireNonNull(getOppositeSideLengthMethod()).invoke(peripheralGap,1, 22.5));
            assertEquals(1.7321, getOppositeSideLengthMethod().invoke(peripheralGap, 1, 30));
            assertEquals(1.0, getOppositeSideLengthMethod().invoke(peripheralGap, 1, 45));
            assertEquals(0.5774, getOppositeSideLengthMethod().invoke(peripheralGap, 1, 60));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    @DisplayName("Must return a algorithm exception when the opposite side is 0")
    public void MustReturnAAlgorithmExceptionWhenTheOppositeSideIsZero() {
        try {
            Objects.requireNonNull(getOppositeSideLengthMethod()).invoke(peripheralGap, 1, 0);
        } catch (Exception e) {
            assertThrows(InvocationTargetException.class, () -> {
                throw e;
            });
        }
    }

    @Test
    @DisplayName("Must return a algorithm exception when the opposite side is 90")
    public void MustReturnAAlgorithmExceptionWhenTheOppositeSideIsNinety() {
        try {
            Objects.requireNonNull(getOppositeSideLengthMethod()).invoke(peripheralGap, 1, 90);
        } catch (Exception e) {
            assertThrows(InvocationTargetException.class, () -> {
                throw e;
            });
        }
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an null peripheral gap for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnNullPeripheralGapForARectangle() throws Exception {
        Surface testSurface = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 0);
        Surface peripheralGapSurface = peripheralGap.compute();

        Surface expectedOutput = new Surface.Builder()
                .add(0,100)
                .add(200,100)
                .add(200,0)
                .add(0,0)
                .build();

        expectedOutput.getCoordinates().forEach((key, value) -> {
            try {
                assertEquals(value, peripheralGapSurface.getCoordinates().get(key));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
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

        expectedOutput.getCoordinates().forEach((key, value) -> {
            try {
                assertEquals(value, peripheralGap.compute().getCoordinates().get(key));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 2 for a rectangle")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOfTwoForARectangle() {
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

        expectedOutput.getCoordinates().forEach((key, value) -> {
            try {
                assertEquals(value, peripheralGap.compute().getCoordinates().get(key));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 1 for a surface with multiple points and only right angles")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForASurfaceWithMultiplePointsAndOnlyRightAngles() {
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

        expectedOutput.getCoordinates().forEach((key, value) -> {
            try {
                assertEquals(value, peripheralGap.compute().getCoordinates().get(key));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    @DisplayName("Must return the surface to be laid out with an peripheral gap of 1 for a trapezoidal surface")
    public void MustReturnTheSurfaceToBeLaidOutWithAnExpansionGapOf1ForATrapezoidalSurface() throws Exception {
        Surface testSurface = new Surface.Builder()
                .add(0,50)
                .add(200,50)
                .add(150,0)
                .add(50,0)
                .build();

        PeripheralGap peripheralGap = new PeripheralGap(testSurface, 1);
        Surface periferalGapSurface = peripheralGap.compute();

        Surface expectedOutput = new Surface.Builder()
                .add(2.4142, 49)
                .add(197.5858, 49)
                .add(149.5858, 1)
                .add(50.4142, 1)
                .build();

        expectedOutput.getCoordinates().forEach((key, value) -> {
            try {
                assertEquals(value, periferalGapSurface.getCoordinates().get(key));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}