package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Cerberus;
import com.ldts.mythsmists.model.Elements.Element;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;

import java.util.Collections;
import java.util.List;

public class Map2Viewer extends Viewer<Map> {

    public Map2Viewer(Map map) {
        super(map);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawTerrain(new Position(0, 0));
        drawElements(gui, getModel().getEnemys(), new EnemyViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getOrpheus(), new OrpheusViewer());
        drawElement(gui, getModel().getCheckpoint(), new CheckpointViewer());
        drawElement(gui, getModel().getCerberus(), new CerberusViewer());


        gui.drawText(new Position(1, 0), "Cerebrus is awake!", "#FFFFFF");
        gui.drawText(new Position(1, 1),"AVOID BEING ON ITS' WAY!", "#FF0000" );
        gui.drawText(new Position(1, 3), "Energy: " + getModel().getOrpheus().getEnergy(), "#FFD700");
        
    }

    private void drawElement(GUI gui, List<Cerberus> cerberus, CerberusViewer cerberusViewer) {
        for (Cerberus cerb : cerberus) {
                cerberusViewer.draw(cerb, gui);
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
