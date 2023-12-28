package com.ldts.mythsmists.viewer.game;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Dracma;


public class DracmaViewer implements ElementViewer<Dracma> {
    @Override
    public void draw(Dracma dracma, GUI gui) { gui.drawDracma(dracma.getPosition());}
}
