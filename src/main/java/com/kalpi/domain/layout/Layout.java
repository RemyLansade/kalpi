package com.kalpi.domain.layout;

public class Layout {

    private final Surface surface;
    private Surface surfaceWithPeripheralGap;

    public Layout(Surface surface) {
        this.surface = surface;
        this.surfaceWithPeripheralGap = surface;
    }

    public Surface getSurface() {
        return surface;
    }

    public void addPeripheralGap(int i) throws Exception {
        this.surfaceWithPeripheralGap = new PeripheralGap(this.surface, i).compute();
    }

    public Surface getSurfaceWithPeripheralGap() {
        return this.surfaceWithPeripheralGap;
    }
}
