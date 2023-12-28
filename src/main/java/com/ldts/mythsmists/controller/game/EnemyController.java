package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.Enemy;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;

import java.util.List;


public class EnemyController extends GameController {
    private long lastMovement;
    public EnemyController(Map map) {
        super(map);
        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        List<Enemy> enemies = getModel().getEnemys();

        if (enemies != null) {
            for (Enemy enemy : enemies) {
                moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
            }
        for (Enemy enemy : getModel().getEnemys())
            moveEnemy(enemy, enemy.getPosition().getRandomNeighbour());
        }
        this.lastMovement = time;
    }

    public void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position)) {
            enemy.setPosition(position);
            if (getModel().getOrpheus().getPosition().equals(position))
                getModel().getOrpheus().decreaseEnergy();
        }
    }
}
