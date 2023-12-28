package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.game.Map2Controller;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.game.Map2Viewer;

public class Act2State extends State<Map>{
    public Act2State(Map map) {super(map);}

    @Override
    protected Viewer<Map> getViewer() {
        return new Map2Viewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new Map2Controller(getModel());
    }
}
