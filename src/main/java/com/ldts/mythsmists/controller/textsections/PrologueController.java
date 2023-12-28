package com.ldts.mythsmists.controller.textsections;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.game.map.MapLoader;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.Act1State;

import java.io.IOException;


public class PrologueController extends Controller<TextSection>{

    public PrologueController(TextSection prologue) {
        super(prologue);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.SELECT) {
          game.setState(new Act1State(new MapLoader(1).createMap()));
        }
    }
}
