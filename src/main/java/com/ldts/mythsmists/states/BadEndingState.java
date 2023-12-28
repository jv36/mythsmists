package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.textsections.EndingController;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;

import java.util.Arrays;
import java.util.List;


public class BadEndingState extends State<TextSection> {
    public BadEndingState(TextSection ts) {
        super(ts);
        List<String> sentences = Arrays.asList("Bad Ending",
                "Through shadows deep, where echoes weave,",
                "Orpheus walks, a heart deceived.",
                "Eurydice's hand in his holds tight,",
                "Yet doubt creeps in, a silent blight.",
                "",
                "A glance backward, a moment's doubt,",
                "The underworld's grip tightens about.",
                "Eurydice fades, love's cruel jest,",
                "A lover's choice, a heart distressed.",
                "",
                "In Hades' realm, where shadows loom,",
                "Orpheus faces impending doom.",
                "Eurydice lost in shadows' play,",
                "A lover's misstep, love in decay.",
                 "",
                "The path ahead, a lone refrain,",
                "A shattered love, a bitter bane.",
                "The interlude ends, a tragic rhyme,",
                "A lover's sorrow, frozen in time."
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