package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.viewer.menu.OptionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class OptionsMenuViewerTest {

    private GUI gui;
    private OptionsMenu menu;
    private OptionsMenuViewer viewer;

    @BeforeEach
    void setMenu() {
        menu = new OptionsMenu();
        viewer = new OptionsMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawMenu() throws IOException, InterruptedException {
        viewer.draw(gui);
        for (int i = 0; i < menu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 7 + i), menu.getEntry(i), menu.isSelected(i) ? "#0092A2" : "#FFFFFF");
        }
    }
}
