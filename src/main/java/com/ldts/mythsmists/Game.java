package com.ldts.mythsmists;

import com.ldts.mythsmists.gui.LanternaGUI;
import com.ldts.mythsmists.sound.AudioPlayer;
import com.ldts.mythsmists.states.State;
import com.ldts.mythsmists.states.MenuState;
import com.ldts.mythsmists.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {

    private final LanternaGUI gui;
    private State state;

    private AudioPlayer player;
    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(150, 150);
        this.state = new MenuState(new Menu());
        this.player = new AudioPlayer("./src/main/resources/music/overture.wav");
        player.play();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public AudioPlayer getPlayer() {
        return player;
    }

    public void setPlayer(String file) {
        player.stop();
        this.player = new AudioPlayer(file);
        player.play();
    }

    public State getCurrentState() {
        return state;
    }

    void start() throws IOException, InterruptedException {
        int FPS = 10;
        int frameTime = 1000/FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;


            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
        gui.close();
    }
}
