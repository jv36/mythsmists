package com.ldts.mythsmists.states;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.menu.MenuController;
import com.ldts.mythsmists.controller.menu.OptionsMenuController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.menu.MenuViewer;
import com.ldts.mythsmists.viewer.menu.OptionsMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.ldts.mythsmists.controller.Controller;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;


public class MenuStateTest {

    private MenuState state;
    private MenuController mockController;
    private MenuViewer mockViewer;

    @BeforeEach
    public void setUp() {
        mockController = Mockito.mock(MenuController.class);
        mockViewer = Mockito.mock(MenuViewer.class);

        state = new MenuState(new Menu()) {
            @Override
            protected Viewer<Menu> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<Menu> getController() {
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
