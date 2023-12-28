package com.ldts.mythsmists.controller.menu;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.states.MenuState;
import java.io.IOException;

public class OptionsMenuController extends Controller<OptionsMenu> {

    public OptionsMenuController(OptionsMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch(action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelected(0)) game.getPlayer().volUp();
                if (getModel().isSelected(1)) game.getPlayer().volDown();
                if (getModel().isSelected(2)) game.getPlayer().stop();
                if (getModel().isSelected(3)) game.setPlayer("./src/main/resources/music/cancan.wav");
                if (getModel().isSelected(4)) game.setState(new MenuState(new Menu()));

                break;
        }
    }
}