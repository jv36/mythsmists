package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.textsections.Interlude1Controller;
import com.ldts.mythsmists.controller.textsections.PrologueController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.Act1State;
import com.ldts.mythsmists.states.Act2State;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class Interlude1ControllerTest {

    @Test
    public void testSelectStep() throws IOException {
        TextSection mockTextSection = mock(TextSection.class);
        Interlude1Controller interludeController = new Interlude1Controller(mockTextSection);
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        long time = System.currentTimeMillis();

        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        interludeController.step(mockGame, GUI.ACTION.SELECT, time);

        // verificar se o estado passa a ser um menustate
        verify(mockGame).setState(isA(Act2State.class));
        verify(mockGame).setState(argThat(state -> {
            Act2State actState = (Act2State) state;
            return actState.getModel() != null;
        }));

        // ver se ñ há mais interações
        verifyNoMoreInteractions(mockGame, mockGui);
    }
}
