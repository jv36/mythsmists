package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;

public class OrpheusViewer implements ElementViewer<Orpheus>{
    @Override
    public void draw(Orpheus orpheus, GUI gui) {
        gui.drawOrpheus(orpheus.getPosition());
    }
}

