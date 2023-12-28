package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.viewer.game.OrpheusViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrpheusViewerTest {

    private Orpheus orpheus;
    private OrpheusViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUpOrpheus() {
        orpheus = new Orpheus(10, 10);
        viewer = new OrpheusViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawOrpheus() {
        viewer.draw(orpheus, gui);
        Mockito.verify(gui, Mockito.times(1)).drawOrpheus(orpheus.getPosition());
    }
}
