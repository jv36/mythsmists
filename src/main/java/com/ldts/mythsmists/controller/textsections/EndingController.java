package com.ldts.mythsmists.controller.textsections;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.MenuState;

import java.io.IOException;

public class EndingController extends Controller<TextSection> {

    public EndingController(TextSection ts) {
        super(ts);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT) game.setState(new MenuState(new Menu()));
    }
}