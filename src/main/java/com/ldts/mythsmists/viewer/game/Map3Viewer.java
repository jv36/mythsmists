package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Element;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;

import java.util.Collections;
import java.util.List;

public class Map3Viewer extends Viewer<Map> {

    public Map3Viewer(Map map) {
        super(map);
    }


    @Override
    protected void drawElements(GUI gui) {
        gui.drawTerrain(new Position(0, 0));
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getOrpheus(), new OrpheusViewer());

        gui.drawText(new Position(1, 0), "Do you think it's the right time?", "#FFFFFF");
        gui.drawText(new Position(1, 1),"Press L to look back.", "#FF0000" );
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        List<T> validElements = (elements != null) ? elements : Collections.emptyList();

        for (T element : validElements) {
            drawElement(gui, element, viewer);
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
