package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Water;

public class WaterViewer implements ElementViewer<Water> {

    @Override
    public void draw(Water water, GUI gui) {
        gui.drawWater(water.getPosition());
    }
}
