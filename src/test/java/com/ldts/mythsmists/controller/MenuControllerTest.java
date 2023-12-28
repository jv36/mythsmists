package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.menu.MenuController;
import com.ldts.mythsmists.controller.textsections.Interlude2Controller;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.Act1State;
import com.ldts.mythsmists.states.Act3State;
import com.ldts.mythsmists.states.OptionsMenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class MenuControllerTest {

    @Test
    public void testSelectStep() throws IOException {
        Menu mockMenu = mock(Menu.class);
        MenuController menuController = new MenuController(mockMenu);
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        long time = System.currentTimeMillis();

        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        menuController.step(mockGame, GUI.ACTION.SELECT, time);

        if (mockMenu.isSelected(0)) {
            // verificar se o estado passa a ser um menustate
            verify(mockGame).setState(isA(Act1State.class));
            verify(mockGame).setState(argThat(state -> {
                Act1State actState = (Act1State) state;
                return actState.getModel() != null;
            }));
        }
        else if (mockMenu.isSelected(1)) {
            verify(mockGame).setState(isA(OptionsMenuState.class));
            verify(mockGame).setState(argThat(state -> {
                OptionsMenuState optState = (OptionsMenuState) state;
                return optState.getModel() != null;
            }));
        }
        else if (mockMenu.isSelected(2)){
            verify(mockGame).setState(null);
        }

        // ver se ñ há mais interações
        verifyNoMoreInteractions(mockGame, mockGui);
    }
}
