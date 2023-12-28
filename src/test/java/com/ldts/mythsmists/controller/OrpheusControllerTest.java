package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.controller.game.OrpheusController;
import com.ldts.mythsmists.model.Elements.Checkpoint;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.Elements.Wall;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class OrpheusControllerTest {

    private Orpheus orpheus;
    private Map map;
    private OrpheusController controller;


    @BeforeEach
    void createPlayer() {
        orpheus = new Orpheus(10, 10);
        map = new Map(30, 20);
        map.setOrpheus(orpheus);
        map.setWalls(List.of());
        map.setEnemys(List.of());
        map.setDracmas(List.of());
        map.setCheckpoint(new Checkpoint(0,0));
        map.setLookSpace(List.of());
        map.setRivers(List.of());
        controller = new OrpheusController(map);
    }

    @Test
    void moveRightEmpty() {
        controller.moveOrpheusRight();
        assertEquals(new Position(11, 10), orpheus.getPosition());
    }


    @Test
    void moveRightNotEmpty() {
        map.setWalls(List.of(new Wall(11, 10)));
        controller.moveOrpheusRight();
        assertEquals(new Position(10, 10), orpheus.getPosition());
    }

    @Test
    void dracmaCounterTest() {
        orpheus.increaseCount();
        assertEquals(1, orpheus.getCount());
    }



}
