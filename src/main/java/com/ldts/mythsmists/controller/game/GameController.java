package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.controller.Controller;
import com.ldts.mythsmists.model.game.map.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }

}
