package com.ldts.mythsmists.gui;

import com.ldts.mythsmists.model.Position;

import java.io.IOException;

public interface GUI {

    void drawOrpheus(Position position);

    void drawWall(Position position);

    void drawDracma(Position position);

    void drawEnemy(Position position);

    void drawTerrain(Position position);

    void drawWater(Position position);

    void drawCheckpoint(Position position);

    void drawCerberus(Position position);

    void drawText(Position position, String text, String color);


    void clear();

    void refresh() throws IOException;

    void close() throws IOException;



    enum ACTION {UP, DOWN, LEFT, RIGHT, QUIT, SELECT, NONE, LOOK}
    ACTION getNextAction() throws IOException;
}
