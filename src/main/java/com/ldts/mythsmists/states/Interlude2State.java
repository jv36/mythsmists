package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.textsections.Interlude2Controller;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;

import java.util.Arrays;
import java.util.List;

public class Interlude2State extends State<TextSection> {
    public Interlude2State(TextSection ts) {
        super(ts);
        List<String> sentences = Arrays.asList(
                "In twilight's grasp, where shadows blend,",
                "Orpheus embarks, love's quest to mend.",
                "To Hades' hall, a daring plea,",
                "A chance to set Eurydice free.",
                "" ,
                "Through Stygian mist and solemn gloom,",
                "Orpheus leads through the shadowed tomb.",
                "A whispered pact, a lover's pact,",
                "To guide her forth, an arduous act.",
                "" ,
                "Yet, Hades warns with a stern decree,",
                "Look not back, to sunlight flee.",
                "The path unfolds, a fateful line,",
                "Love's redemption or fate malign.",
                "" ,
                "Eurydice walks in silent stride,",
                "Orpheus battles doubt inside.",
                "The choice awaits, a moment dire,",
                "To look back now or walk through fire.",
                "" ,
                "In Hades' realm, where shadows play,",
                "A lover hesitates, love at bay.",
                "The interlude unfolds its rhyme,",
                "A choice profound, frozen in time.",
                "" ,
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
        return new Interlude2Controller(getModel());
    }
}
