package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Cerberus;


public class CerberusViewer implements ElementViewer<Cerberus>{
    @Override
    public void draw(Cerberus cerberus, GUI gui) {
        gui.drawCerberus(cerberus.getPosition());
    }
}
