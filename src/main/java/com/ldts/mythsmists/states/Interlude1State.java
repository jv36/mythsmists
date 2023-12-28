package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.textsections.Interlude1Controller;
import com.ldts.mythsmists.model.textsections.TextSection;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.textsections.TextSectionViewer;

import java.util.Arrays;
import java.util.List;

public class Interlude1State extends State<TextSection>{
    public Interlude1State(TextSection ts) {
        super(ts);
        List<String> sentences = Arrays.asList("In Hades' grip, where shadows sprawl,",
                "Orpheus strides, a lover's call." ,
                "Cerberus guards the gates of gloom," ,
                "Three heads, fierce guardian of the tomb." ,
                "" ,
                "With lyre in hand, a melody weaves," ,
                "Notes of hope, the underworld perceives." ,
                "Cerberus, once fierce, lulled by the song,",
                "Entranced, in slumber, it rests along." ,
                "",
                "Orpheus moves through the silent night," ,
                "Love's echo guiding, a beacon bright." ,
                "In Hades' realm, where shadows fade,n" ,
                "A lover's song, redemption laid.",
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
        return new Interlude1Controller(getModel());
    }
}
