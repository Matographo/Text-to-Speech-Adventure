package de.ttsa.Logic.Player.Functions.PlayerFunctions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {
    
    private static boolean isRunning = false;
    private static Thread musicThread;
    private static float volume = 0.0f;
    private static boolean isNewQueue = false;
    private static Queue<ByteArrayInputStream> musicList;
    private static Player player;

    public MusicPlayer() {
    }
    
    public static void playMusic() {
        if (!isRunning) {
            musicThread = new Thread() {
                @Override
                public void run() {
                    try {
                        isRunning = true;
                        startMusic();
                    } catch (InterruptedException e) {
                        System.out.println("Music Thread Interrupted");
                    }
                }
            };
            musicThread.start();
        }
    }

    private static void startMusic() throws InterruptedException {
        while (!musicList.isEmpty() && isRunning) {
            try {
                
                ByteArrayInputStream clip = musicList.poll();
                clip.reset();
                musicList.add(clip);
                player = new Player(clip);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setMusicList(List<InputStream> musicStreams) {
        try {
            Queue<ByteArrayInputStream> newMusicList = new LinkedList<>();
            for (InputStream stream : musicStreams) {
                ByteArrayInputStream clip = new ByteArrayInputStream(stream.readAllBytes());
                newMusicList.add(clip);
            }
            endPlayer();
            musicList = newMusicList;
            if(isRunning()) {
                playMusic();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean isRunning() {
        return player != null && !player.isComplete() && isRunning;
    }

    public static void stopMusic() {
        if(player != null) {
            player.close();
        }
        isRunning = false;
    }

    public static void endPlayer() {
        isRunning = false;
        stopMusic();
        if(musicThread != null) musicThread.interrupt();
    }
}
