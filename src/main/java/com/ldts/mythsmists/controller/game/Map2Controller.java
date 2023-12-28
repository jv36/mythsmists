package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.*;

import java.io.IOException;

public class Map2Controller extends GameController {
    private final OrpheusController orpheusController;
    private final CerberusController cerberusController;
    private final EnemyController enemyController;

    public Map2Controller(Map map) {
        super(map);
        this.orpheusController = new OrpheusController(map);
        this.cerberusController = new CerberusController(map);
        this.enemyController = new EnemyController(map);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Orpheus orpheus = getModel().getOrpheus();
        if (action == GUI.ACTION.QUIT || (orpheus != null && orpheus.getEnergy() == 0)) {
            game.setState(new MenuState(new Menu()));
        }
        else if (getModel().getOrpheus().get_hasReachedCheckpoint()) {
            game.setState(new Interlude2State(new TextSection()));
        }
        else {
            orpheusController.step(game, action, time);
            cerberusController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }

}

