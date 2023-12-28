package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.menu.MenuController;
import com.ldts.mythsmists.controller.menu.OptionsMenuController;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.states.Act1State;
import com.ldts.mythsmists.states.MenuState;
import com.ldts.mythsmists.states.OptionsMenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class OptionsMenuControllerTest {

    @Test
    public void testSelectStep() throws IOException {
        OptionsMenu mockMenu = mock(OptionsMenu.class);
        OptionsMenuController menuController = new OptionsMenuController(mockMenu);
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        long time = System.currentTimeMillis();

        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.SELECT);
        menuController.step(mockGame, GUI.ACTION.SELECT, time);

        if (mockMenu.isSelected(4)) {
            // verificar se o estado passa a ser um menustate
            verify(mockGame).setState(isA(MenuState.class));
            verify(mockGame).setState(argThat(state -> {
                MenuState menuState = (MenuState) state;
                return menuState.getModel() != null;
            }));
        }

        // ver se ñ há mais interações
        verifyNoMoreInteractions(mockGame, mockGui);
    }
}
