package com.ldts.mythsmists.states;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.controller.menu.MenuController;
import com.ldts.mythsmists.model.menu.Menu;
import com.ldts.mythsmists.viewer.Viewer;
import com.ldts.mythsmists.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {

    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
