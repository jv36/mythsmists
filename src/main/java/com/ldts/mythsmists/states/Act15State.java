package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.game.Map15Controller;
import com.ldts.mythsmists.model.game.map.Map;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.game.Map15Viewer;

public class Act15State extends State<Map>{

    public Act15State(Map map) { super(map);}

    @Override
    protected Viewer<Map> getViewer() {
        return new Map15Viewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new Map15Controller(getModel());
    }

}
