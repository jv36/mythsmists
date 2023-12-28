package com.ldts.mythsmists.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.ldts.mythsmists.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.googlecode.lanterna.TextColor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LanternaGUITest {


    private Screen mockScreen;
    private TextGraphics mockTextGraphics;
    private LanternaGUI lanternaGUI;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        mockScreen = mock(Screen.class);
        mockTextGraphics = mock(TextGraphics.class);
        lanternaGUI = new LanternaGUI(150, 150);
        lanternaGUI.screen = mockScreen;

        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
    }

    @Test
    void testDrawOrpheus() {
        Position position = new Position(10, 10);
        lanternaGUI.drawOrpheus(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "}");
    }

    @Test
    void testDrawWall() {
        Position position = new Position(10, 10);
        lanternaGUI.drawWall(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setBackgroundColor(TextColor.Factory.fromString("#B80D15"));
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#222224"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "&");
    }

    @Test
    void testDrawDracma() {
        Position position = new Position(10, 10);
        lanternaGUI.drawDracma(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "$");
    }

    @Test
    void testDrawEnemy() {
        Position position = new Position(10, 10);
        lanternaGUI.drawEnemy(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "\\");
    }

    @Test
    void testDrawCerberus() {
        Position position = new Position(10, 10);
        lanternaGUI.drawCerberus(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#324AA8"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "[");
    }

    @Test
    void testDrawCheckpoint() {
        Position position = new Position(10, 10);
        lanternaGUI.drawCheckpoint(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#F5428D"));
        verify(mockScreen.newTextGraphics()).putString(position.getX(), position.getY() - 1, "F");
    }
    @Test
    void testDrawWater() {
        Position position = new Position(10, 10);
        lanternaGUI.drawWater(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setBackgroundColor(TextColor.Factory.fromString("#44A6C6"));
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#4465C6"));
        verify(mockScreen.newTextGraphics()).enableModifiers(SGR.BOLD);
        verify(mockScreen.newTextGraphics()).fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(2, 2), '~');
    }

    @Test
    void testDrawTerrain() {
        Position position = new Position(10, 10);
        lanternaGUI.drawTerrain(position);

        verify(mockScreen).newTextGraphics();
        verify(mockScreen.newTextGraphics()).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        verify(mockScreen.newTextGraphics()).setForegroundColor(TextColor.Factory.fromString("#212021"));
        verify(mockScreen.newTextGraphics()).enableModifiers(SGR.BOLD);
        verify(mockScreen.newTextGraphics()).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(150, 150), '%');
    }

    @Test
    void testClear() throws IOException {
        lanternaGUI.clear();
        verify(mockScreen).clear();
    }

    @Test
    void testRefresh() throws IOException {
        lanternaGUI.refresh();
        verify(mockScreen).refresh();
    }

    @Test
    void testClose() throws IOException {
        lanternaGUI.close();
        verify(mockScreen).close();
    }
}
