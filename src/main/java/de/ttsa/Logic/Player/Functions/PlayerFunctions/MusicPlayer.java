package de.ttsa.Logic.Player.Functions.PlayerFunctions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
    
    private static float volume = 0.0f;

    private static boolean isRunning = false;
    private static boolean isNewQueue = false;
    private static boolean isPlaying = false;
    private static Queue<Clip> musicList; 

    public MusicPlayer() {
    }

    public static void playMusic() {
        if (!isRunning) {
            Thread musicThread = new Thread(() -> {
                try {
                    isRunning = true;
                    isPlaying = true;
                    startMusic();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            musicThread.start();
        }
    }

    public static void startMusic() throws InterruptedException {
        FloatControl volume;
        while (!musicList.isEmpty()) {
            isNewQueue = false;
            Clip currentClip = musicList.poll();
            musicList.add(currentClip);
            volume = (FloatControl) currentClip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(MusicPlayer.volume);
            currentClip.start();
            Thread.sleep(5);
            while (currentClip.isRunning() && !isNewQueue && isPlaying) {
                Thread.sleep(10);
            }
            currentClip.stop();
            currentClip.setMicrosecondPosition(0);
        }
    }

    public static void setMusicList(List<InputStream> musicStreams) {
    try {
        Queue<Clip> newMusicList = new LinkedList<>();
        for (InputStream stream : musicStreams) {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(stream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            newMusicList.add(clip);
        }
        musicList = newMusicList;
        isNewQueue = true;
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
}

    public static void setMusicPlaying(boolean isPlaying) {
        MusicPlayer.isPlaying = isPlaying;
    }
    

    public static void setVolume(int volumePercentage) {
        if (volumePercentage < 0 || volumePercentage > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100");
        }

        if(volumePercentage == 0) {
            MusicPlayer.volume = -80.0f;
            return;
        }
        MusicPlayer.volume = (6.0f - -40.0f) * (volumePercentage / 100.0f) + -40.0f;
    }

}
