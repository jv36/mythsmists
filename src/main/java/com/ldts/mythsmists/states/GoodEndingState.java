package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.textsections.EndingController;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;

import java.util.Arrays;
import java.util.List;

public class GoodEndingState extends State<TextSection> {
    public GoodEndingState(TextSection ts) {
        super(ts);
        List<String> sentences = Arrays.asList("Good ending",
                "Through shadows deep, where echoes thrum,",
                "Orpheus walks, love's song begun.",
                "Eurydice's hand in his entwined,",
                "A love rekindled, fate aligned.",
                " ",
                "No backward glances, doubts dismissed,",
                "The underworld yields to love's sweet tryst.",
                "Gates part, daylight welcomes the pair,",
                "Orpheus and Eurydice, a love affair.",
                "",
                "In Hades' realm, where shadows wane,",
                "A lover triumphs, breaks the chain.",
                "Eurydice walks in daylight's gleam,",
                "A lover's dream, a cherished theme."
        );
        ts.setSentences(sentences);
    }

    @Override
    protected Viewer<TextSection> getViewer() {
        return new TextSectionViewer(getModel());
    }

    @Override
    protected Controller<TextSection> getController() {
        return new EndingController(getModel());
    }
}
