package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.textsections.EndingController;
import com.ldts.mythsmists.controller.textsections.PrologueController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.Act1State;
import com.ldts.mythsmists.states.MenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class PrologueControllerTest {

    @Test
    public void testSelectStep() throws IOException {
        TextSection mockTextSection = mock(TextSection.class);
        PrologueController prologueController = new PrologueController(mockTextSection);
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        long time = System.currentTimeMillis();

        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        prologueController.step(mockGame, GUI.ACTION.SELECT, time);

        // verificar se o estado passa a ser um menustate
        verify(mockGame).setState(isA(Act1State.class));
        verify(mockGame).setState(argThat(state -> {
            Act1State actState = (Act1State) state;
            return actState.getModel() != null;
        }));

        // ver se ñ há mais interações
        verifyNoMoreInteractions(mockGame, mockGui);
    }
}
