package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Dracma;
import com.ldts.mythsmists.model.Elements.Element;
import com.ldts.mythsmists.model.Elements.Water;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;

import java.util.Collections;
import java.util.List;

public class Map15Viewer extends Viewer<Map> {
    public Map15Viewer(Map map) {
        super(map);
    }


    @Override
    protected void drawElements(GUI gui) {
        gui.drawTerrain(new Position(0, 0));
        drawRiver(gui, getModel().getRivers(), new WaterViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getEnemys(), new EnemyViewer());
        drawElement(gui, getModel().getOrpheus(), new OrpheusViewer());
        drawElement(gui, getModel().getDracmas(), new DracmaViewer());
        drawElement(gui, getModel().getCheckpoint(), new CheckpointViewer());


        gui.drawText(new Position(1, 0), "Get 5 more dracmas, you're almost there!", "#FFFFFF");
        gui.drawText(new Position(1, 1),"DO NOT GET CAUGHT!", "#FF0000" );

        gui.drawText(new Position(1, 3), "Energy: " + getModel().getOrpheus().getEnergy(), "#FFD700");
        gui.drawText(new Position(12, 3), "Dracmas: " + getModel().getOrpheus().getCount(), "#FFD700");
    }

    private void drawRiver(GUI gui, List<Water> rivers, WaterViewer waterViewer) {
        for (Water water : rivers) {
            waterViewer.draw(water, gui);
        }
    }

    private void drawElement(GUI gui, List<Dracma> dracmas, DracmaViewer dracmaViewer) {
        for (Dracma dracma : dracmas) {
            dracmaViewer.draw(dracma, gui);
        }
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
