package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {

    private GUI gui;
    private Menu menu;
    private MenuViewer viewer;

    @BeforeEach
    void setMenu() {
        menu = new Menu();
        viewer = new MenuViewer(menu);
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
