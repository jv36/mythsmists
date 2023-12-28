package com.ldts.mythsmists.controller.game;

import com.ldts.mythsmists.Game;
import com.ldts.mythsmists.gui.GUI;
import com.ldts.mythsmists.model.Position;
import com.ldts.mythsmists.model.game.map.Map;
import java.io.IOException;

public class OrpheusController extends GameController{

    public OrpheusController(Map map){super(map);}

    public void moveOrpheusLeft(){ moveOrpheus(getModel().getOrpheus().getPosition().getLeft());}
    public void moveOrpheusRight(){ moveOrpheus(getModel().getOrpheus().getPosition().getRight());}
    public void moveOrpheusUp(){ moveOrpheus(getModel().getOrpheus().getPosition().getUp());}

    public void moveOrpheusDown(){ moveOrpheus(getModel().getOrpheus().getPosition().getDown());}

    public void moveOrpheus(Position position) {
        if(getModel().isEmpty(position)){
            getModel().getOrpheus().setPosition(position);
            if(!(getModel().isEnemy(position))){
                getModel().getOrpheus().decreaseEnergy();
            }
            if(!(getModel().isDracma(position))){
                getModel().getOrpheus().increaseCount();
                getModel().getDracmas().removeIf(dracma -> dracma.getPosition().equals(position));
            }
            if(!(getModel().isCheckpoint(position))) {
                getModel().getOrpheus().set_HasReachedCheckpoint();
            }
            if(!(getModel().isLookSpace(position))) {
                getModel().getOrpheus().set_isLookSpace();
            }
            if(!(getModel().isWater(position))) {
                getModel().getOrpheus().decreaseEnergy();
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
            if (action == GUI.ACTION.UP) {
                moveOrpheusUp();
            }
            if (action == GUI.ACTION.RIGHT) moveOrpheusRight();
            if (action == GUI.ACTION.DOWN) moveOrpheusDown();
            if (action == GUI.ACTION.LEFT) moveOrpheusLeft();
            if (action == GUI.ACTION.LOOK) getModel().getOrpheus().set_lookback();
    }
}
