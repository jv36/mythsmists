package com.ldts.mythsmists.viewer;

import java.io.IOException;
import com.ldts.mythsmists.gui.GUI;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException, InterruptedException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui) throws IOException, InterruptedException;
}
