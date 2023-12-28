package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Elements.LookSpace;
import com.ldts.mythsmists.model.Elements.Orpheus;
import com.ldts.mythsmists.model.Elements.Wall;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.game.Map3Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class Map3ViewerTest {

    private Orpheus orpheus;
    private Map map;
    private GUI gui;
    private Map3Viewer viewer;

    @BeforeEach
    void setup() {
        orpheus = new Orpheus(10, 10);
        gui = Mockito.mock(GUI.class);
        map = new Map(150, 150);
        viewer = new Map3Viewer(map);

        map.setOrpheus(orpheus);
        map.setWalls(Arrays.asList(new Wall(3,3), new Wall(4,5), new Wall(7, 7), new Wall(10, 20), new Wall(30, 40)));
        map.setLookSpace(Arrays.asList(new LookSpace(60, 60), new LookSpace(60, 61), new LookSpace(61, 62), new LookSpace(63, 64), new LookSpace(65, 66)));

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
}
