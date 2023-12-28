package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.menu.OptionsMenuController;
import com.ldts.mythsmists.model.menu.OptionsMenu;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.menu.OptionsMenuViewer;

public class OptionsMenuState extends State<OptionsMenu> {
    public OptionsMenuState(OptionsMenu model) {
        super(model);
    }

    @Override
    protected Viewer<OptionsMenu> getViewer() {
        return new OptionsMenuViewer(getModel());
    }

    @Override
    protected Controller<OptionsMenu> getController() {
        return new OptionsMenuController(getModel());
    }
}
