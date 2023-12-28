package com.ldts.mythsmists.viewer.menu;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.viewer.Viewer;

public class OptionsMenuViewer extends Viewer<OptionsMenu> {

    public OptionsMenuViewer(OptionsMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "{OPTIONS{", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#0092A2" : "#FFFFFF");
        }

        gui.drawText(new Position(5, 15), "©Music by Jacques Offenbach, from 'Orpheus in the Underworld'", "#FFFFFF");
    }
}
