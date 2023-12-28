package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.GoodEndingState;
import com.ldts.mythsmists.states.MenuState;
import com.ldts.mythsmists.states.BadEndingState;

import java.io.IOException;
import java.util.Objects;

public class Map3Controller extends GameController {

    private final OrpheusController orpheusController;

    public Map3Controller(Map map) {
        super(map);
        this.orpheusController = new OrpheusController(map);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Orpheus orpheus = getModel().getOrpheus();
        if (action == GUI.ACTION.QUIT || (orpheus != null && orpheus.getEnergy() == 0)) {
            game.setState(new MenuState(new Menu()));
        }
        else if (getModel().getOrpheus().get_isLookSpace() && Objects.requireNonNull(orpheus).get_lookback()) {
            game.setState(new GoodEndingState(new TextSection()));
        }
        else if (!getModel().getOrpheus().get_isLookSpace() && Objects.requireNonNull(orpheus).get_lookback()) {
            game.setState(new BadEndingState(new TextSection()));
        }
        else {
            orpheusController.step(game, action, time);
        }
    }
}
