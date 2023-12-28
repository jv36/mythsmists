package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.states.Interlude1State;
import com.ldts.mythsmists.states.MenuState;

import java.io.IOException;

public class Map15Controller extends GameController {
    private final OrpheusController orpheusController;
    private final EnemyController enemyController;

    public Map15Controller(Map map) {
        super(map);
        this.orpheusController = new OrpheusController(map);
        this.enemyController = new EnemyController(map);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Orpheus orpheus = getModel().getOrpheus();
        if (action == GUI.ACTION.QUIT || (orpheus != null && orpheus.getEnergy() == 0)) {
            game.setState(new MenuState(new Menu()));
        }
        else {
            assert orpheus != null;
            if ((orpheus.getCount() >= 5) && (getModel().getOrpheus().get_hasReachedCheckpoint())){
                game.setState(new Interlude1State(new TextSection()));
            }
            else {
                orpheusController.step(game, action, time);
                enemyController.step(game, action, time);
            }
        }
    }
}
