package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.textsections.PrologueController;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;

import java.util.Arrays;
import java.util.List;


public class PrologueState extends State<TextSection> {
    public PrologueState(TextSection ts) {
        super(ts);
        List<String> sentences = Arrays.asList("Prologue",
                "Once upon a time in ancient Greece," ,
                "Orpheus and Eurydice, a newlywed couple," ,
                "found their love tested by a cruel twist of fate." ,
                "" ,
                "In a quaint village, Orpheus, a gifted musician," ,
                "charmed all with his lyre's enchanting tunes." ,
                "Eurydice, his beloved, possessed beauty that rivaled goddesses." ,
                "" ,
                "Tragedy struck when Eurydice, lured into a meadow," ,
                "fell victim to a serpent's deadly bite." ,
                "Orpheus, unaware, continued his melodies until grief's shadow loomed." ,
                "" ,
                "Learning of Eurydice's demise, he defied death itself," ,
                "venturing to the underworld with his lyre's haunting notes." ,
                "",
                "However, if you want to defy death, you should first pay the price.",
                "",
                "Collect 10 Dracmas, pay Caronte and cross the river",
                "",
                "Or remain in the Underworld forever.",
                "",
                "(Press enter to continue)"
        );
        ts.setSentences(sentences);
    }

    @Override
    protected Viewer<TextSection> getViewer() {
        return new TextSectionViewer(getModel());
    }

    @Override
    protected Controller<TextSection> getController() {
        return new PrologueController(getModel());
    }
}