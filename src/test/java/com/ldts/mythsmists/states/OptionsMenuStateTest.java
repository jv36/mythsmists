package com.ldts.mythsmists.states;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.menu.OptionsMenuController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.menu.OptionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;

public class OptionsMenuStateTest {

    private OptionsMenuState state;
    private OptionsMenuController mockController;
    private OptionsMenuViewer mockViewer;

    @BeforeEach
    public void setUp() {
        mockController = Mockito.mock(OptionsMenuController.class);
        mockViewer = Mockito.mock(OptionsMenuViewer.class);

        state = new OptionsMenuState(new OptionsMenu()) {
            @Override
            protected Viewer<OptionsMenu> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<OptionsMenu> getController() {
                return mockController;
            }
        };
    }
    @Test
    void constructorNotNull() {
        assertNotNull(state.getController());
        assertNotNull(state.getViewer());
    }

    @Test
    void testStep() throws IOException, InterruptedException {
        Game mockGame = Mockito.mock(Game.class);
        GUI mockGui = Mockito.mock(GUI.class);
        long time = System.currentTimeMillis();

        Mockito.when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);

        state.step(mockGame, mockGui, time);

        // verificar se o step é chamado de forma correta
        Mockito.verify(mockController).step(eq(mockGame), eq(GUI.ACTION.SELECT), eq(time));

        // verificar se o draw é chamado com o GUI
        Mockito.verify(mockViewer).draw(eq(mockGui));

        // verificar se não há mais interações entre os mocks
        Mockito.verifyNoMoreInteractions(mockController, mockViewer);
    }
}
