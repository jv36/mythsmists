package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.game.Map3Controller;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.game.Map3Viewer;

public class Act3State extends State<Map> {

    public Act3State(Map map) {super(map);}

    @Override
    protected Viewer<Map> getViewer() {
        return new Map3Viewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new Map3Controller(getModel());
    }
}
