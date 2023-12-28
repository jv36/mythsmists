package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.game.MapController;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.game.Map1Viewer;

public class Act1State extends State<Map>{

    public Act1State(Map map) {super(map);}

    @Override
    protected Viewer<Map> getViewer() {
        return new Map1Viewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }

}
