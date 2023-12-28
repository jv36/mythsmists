package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.textsections.EndingController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.MenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EndingControllerTest {
    @Test
    public void testSelectStep() throws IOException {
        TextSection mockTextSection = mock(TextSection.class);
        EndingController endingController = new EndingController(mockTextSection);
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        long time = System.currentTimeMillis();

        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        endingController.step(mockGame, GUI.ACTION.SELECT, time);

        // verificar se o estado passa a ser um menustate
        verify(mockGame).setState(isA(MenuState.class));
        verify(mockGame).setState(argThat(state -> {
            MenuState menuState = (MenuState) state;
            return menuState.getModel() != null;
        }));

        // ver se ñ há mais interações
        verifyNoMoreInteractions(mockGame, mockGui);
    }
}
