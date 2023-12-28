package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.model.game.map.MapLoader;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.states.*;

import java.io.IOException;

public class MapController extends GameController {
    private OrpheusController orpheusController;
    private final EnemyController enemyController;

    public MapController(Map map) {
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
                game.setState(new Act15State(new MapLoader(15).createMap()));
            }
            else {
                orpheusController.step(game, action, time);
                enemyController.step(game, action, time);
            }
        }
    }

    public void setOrpheusController(OrpheusController orpheusController) {
        this.orpheusController = orpheusController;
    }
}
