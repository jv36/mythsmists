package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.model.Elements.Wall;
import com.ldts.mythsmists.gui.GUI;


public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}