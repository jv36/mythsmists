package com.ldts.mythsmists.sound;

import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {
    protected Clip clip;
    protected FloatControl fc;

    public AudioPlayer(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip.setFramePosition(0);
        fc.setValue(-5.0f);
        clip.start();
    }

    public FloatControl getCurrentVolume() {
        return fc;
    }


    public void stop() {
        clip.stop();
    }

    // allowed threshold -80.0 to 4.206dB
    // setting if conditions to avoid IllegalArgumentException
    // I know, I could just do a try/catch
    public void volUp() {
        if (fc.getValue() < 4.206) fc.setValue(fc.getValue() + 2.0f);
    }

    public void volDown() {
        if (fc.getValue() > -78.0) fc.setValue(fc.getValue() -2.0f);
    }
}