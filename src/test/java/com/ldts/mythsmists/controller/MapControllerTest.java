package com.ldts.mythsmists.controller;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.controller.game.MapController;
import com.ldts.mythsmists.controller.game.OrpheusController;
import com.ldts.mythsmists.model.Elements.Checkpoint;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapControllerTest {

    private MapController controller;
    private OrpheusController orpheusController;
    private Map map;
    private Game game;

    @BeforeEach
    void setupMap() {
        game = Mockito.mock(Game.class);
        map = new Map(150, 150);
        controller = new MapController(map);
        orpheusController = new OrpheusController(map);
        controller.setOrpheusController(orpheusController);
        map.setOrpheus(new Orpheus(50, 50));
        map.setWalls(List.of());
        map.setEnemys(List.of());
        map.setDracmas(List.of());
        map.setCheckpoint(new Checkpoint(51,50));
        map.setLookSpace(List.of());
        map.setRivers(List.of());
    }

    @Test
    void checkpointTest() {
        orpheusController.moveOrpheusRight();
        assertTrue(map.getOrpheus().get_hasReachedCheckpoint());
    }

    @Test
    void checkpointChangesState() throws IOException {
        map.getOrpheus().increaseCount();
        map.getOrpheus().increaseCount();
        map.getOrpheus().increaseCount();
        map.getOrpheus().increaseCount();
        map.getOrpheus().increaseCount();

        orpheusController.moveOrpheusRight();

    }




}
