package com.ldts.mythsmists.viewer.textsections;

import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;

public class TextSectionViewer extends Viewer<TextSection> {

    public TextSectionViewer(TextSection ts) {
        super(ts);
    }

    @Override
    public void drawElements(GUI gui) {

        for (int i = 0; i < getModel().getNumberOfSentences(); i++) {
            gui.drawText(new Position(5, 2+i), getModel().getSentence(i), "#FFFFFF");
        }

    }
}
