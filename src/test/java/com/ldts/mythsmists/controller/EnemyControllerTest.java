package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.model.Elements.Checkpoint;
import com.ldts.mythsmists.model.Elements.Enemy;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.controller.game.EnemyController;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyControllerTest {

    private EnemyController controller;
    private Map map;
    private Enemy enemy;
    private Orpheus orpheus;
    @BeforeEach
    void setup() {
        map = new Map(150, 150);
        orpheus = new Orpheus(10, 10);
        controller = new EnemyController(map);
        enemy = new Enemy(11, 10);
        map.setOrpheus(orpheus);
        map.setWalls(List.of());
        map.setEnemys(List.of(enemy));
        map.setDracmas(List.of());
        map.setCheckpoint(new Checkpoint(0, 0));
        map.setLookSpace(List.of());
        map.setRivers(List.of());
    }

    @Test
    void colliderTest() {
        controller.moveEnemy(enemy, new Position(10, 10));
        assertEquals(orpheus.getEnergy(), 9);
    }
}
