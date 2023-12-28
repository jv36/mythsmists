package com.ldts.mythsmists.viewer;

import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;
import com.ldts.mythsmists.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class TextSectionViewerTest {

    private TextSection ts;
    private TextSectionViewer viewer;

    private GUI gui;

    @BeforeEach
    void setup() {
        ts = new TextSection();
        viewer = new TextSectionViewer(ts);
        gui = Mockito.mock(GUI.class);

        ts.setSentences(Arrays.asList("Test sentence", "This is a really cool test", "I love this sentence", "LDTS is great", "PIT is cool", "Java forever in our hearts"));
    }

    @Test
    void drawTS() throws IOException, InterruptedException {
        viewer.draw(gui);
        for (int i = 0; i < ts.getNumberOfSentences(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 2 + i), ts.getSentence(i), "#FFFFFF");
        }
    }

}
