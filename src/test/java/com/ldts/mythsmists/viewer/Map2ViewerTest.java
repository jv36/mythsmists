package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.*;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.game.Map15Viewer;
import com.ldts.mythsmists.viewer.game.Map2Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class Map2ViewerTest {

    private Orpheus orpheus;
    private Map map;
    private GUI gui;
    private Map2Viewer viewer;

    @BeforeEach
    void setup() {
        orpheus = new Orpheus(10, 10);
        gui = Mockito.mock(GUI.class);
        map = new Map(150, 150);
        viewer = new Map2Viewer(map);

        map.setOrpheus(orpheus);
        map.setWalls(Arrays.asList(new Wall(3,3), new Wall(4,5), new Wall(7, 7), new Wall(10, 20), new Wall(30, 40)));
        map.setEnemys(Arrays.asList(new Enemy(4,4), new Enemy(5, 2), new Enemy(7, 1), new Enemy(10, 23), new Enemy(11, 24)));
        map.setCheckpoint(new Checkpoint(50, 50));
        map.setCerberus(Arrays.asList(new Cerberus(5, 10), new Cerberus(5, 12), new Cerberus(5, 14)));
    }

    @Test
    void drawOrpheus() throws IOException, InterruptedException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawOrpheus(new Position(10,10));
        Mockito.verify(gui, Mockito.times(1)).drawOrpheus(Mockito.any(Position.class));
    }

    @Test
    void drawWalls() throws IOException, InterruptedException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3,3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(4,5));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(7,7));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(10,20));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(30,40));

        Mockito.verify(gui, Mockito.times(5)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawEnemies() throws IOException, InterruptedException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(4, 4));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(5, 2));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(7, 1));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(10, 23));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(11, 24));

        Mockito.verify(gui, Mockito.times(5)).drawEnemy(Mockito.any(Position.class));
    }

    @Test
    void drawCheckpoint() throws IOException, InterruptedException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCheckpoint(new Position(50, 50));
        Mockito.verify(gui, Mockito.times(1)).drawCheckpoint(Mockito.any(Position.class));
    }

    @Test
    void drawCerberus() throws IOException, InterruptedException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCerberus(new Position(5, 10));
        Mockito.verify(gui, Mockito.times(1)).drawCerberus(new Position(5, 12));
        Mockito.verify(gui, Mockito.times(1)).drawCerberus(new Position(5, 14));
        Mockito.verify(gui, Mockito.times(3)).drawCerberus(Mockito.any(Position.class));
    }
}
