package com.ldts.mythsmists.sound;

import com.ldts.mythsmists.sound.AudioPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.FloatControl;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioPlayerTest {

    private AudioPlayer player;
    @BeforeEach
    void setup() {

        player = new AudioPlayer("./src/main/resources/music/overture.wav");
        player.play();
    }

    @Test
    void volumeUpTest() {
        player.volUp();
        assertEquals(round(player.getCurrentVolume().getValue()), -3.0);
    }

    @Test
    void volumeDownTest() {
        player.volDown();
        assertEquals(round(player.getCurrentVolume().getValue()), -7.0);
    }
}
