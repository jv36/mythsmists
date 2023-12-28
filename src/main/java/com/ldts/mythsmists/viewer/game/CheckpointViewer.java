package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Checkpoint;

public class CheckpointViewer implements ElementViewer<Checkpoint> {

    @Override
    public void draw(Checkpoint element, GUI gui) {
        gui.drawCheckpoint(element.getPosition());
    }
}
