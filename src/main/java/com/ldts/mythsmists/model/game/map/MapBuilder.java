package com.ldts.mythsmists.model.game.map;

import com.ldts.mythsmists.model.Elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public abstract class MapBuilder {
    private final Random rng;
    private final int width;
    private final int height;
    private  final int numberOfEnemys;

    public MapBuilder(){
        this.rng = new Random();
        this.width= 0;
        this.height=0;
        this.numberOfEnemys=0;
    }

    public Map createMap() {
        Map map = new Map(width, height);

        map.setRivers(createRivers());
        map.setOrpheus(createOrpheus());
        map.setCerberus(createCerberus());
        map.setWalls(createWalls());
        map.setEnemys(createEnemys());
        map.setDracmas(createDracmas());
        map.setCheckpoint(createCheckpoint());
        map.setLookSpace(createLookSpace());
        return map;
    }

    protected Orpheus createOrpheus(){
        return new Orpheus(width/2,height/2);
    }

    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    protected List<Enemy> createEnemys() {
        List<Enemy> enemys = new ArrayList<>();

        while (enemys.size() < numberOfEnemys)
            enemys.add(new Enemy(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return enemys;
    }

    protected List<Cerberus> createCerberus() {
        List<Cerberus> cerberus = new ArrayList<>();

        while (cerberus.size() < 4)
            cerberus.add(new Cerberus(rng.nextInt(width+1), rng.nextInt(height+1)));

        return cerberus;
    }

    protected List<Dracma> createDracmas() {
        List<Dracma> dracmas = new ArrayList<>();

        while (dracmas.size() < numberOfEnemys)
            dracmas.add(new Dracma(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return dracmas;
    }

    protected List<Water> createRivers() {
        List<Water> rivers = new ArrayList<>();

        while (rivers.size() < numberOfEnemys)
            rivers.add(new Water(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return rivers;
    }

    protected Checkpoint createCheckpoint() {
        return new Checkpoint(0, 0);
    }

    protected List<LookSpace> createLookSpace() {
        List<LookSpace> lookspace = new ArrayList<>();

        while (lookspace.size() < numberOfEnemys)
            lookspace.add(new LookSpace(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return lookspace;
    }
}
