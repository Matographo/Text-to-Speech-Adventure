package de.ttsa.Logic.Player.Functions.PlayerFunctions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import de.ttsa.Container.Couple;
import de.ttsa.Logic.PlayerApp;
import de.ttsa.Tools.SimpleLog;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlayer {
    
    private static boolean isRunning = false;
    private static Thread musicThread;
    private static float volume = 0.0f;
    private static boolean isNewQueue = false;
    private static List<String> musicNames;
    private static Queue<ByteArrayInputStream> musicList;
    private static Player player;
    private static SimpleLog log = PlayerApp.log;

    public MusicPlayer() {
    }
    
    public static void playMusic() {
        if (!isRunning && isNewQueue) {
            musicThread = new Thread() {
                @Override
                public void run() {
                    try {
                        isNewQueue = false;
                        isRunning = true;
                        startMusic();
                    } catch (InterruptedException e) {
                        log.debug("Music Thread Interrupted");
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

    public static void setMusicList(List<Couple<String, InputStream>> musicStreams) {
        try {
            Queue<ByteArrayInputStream> newMusicList = new LinkedList<>();
            List<String> newMusicNames = new ArrayList<>();
            for (Couple<String, InputStream> stream : musicStreams) {
                ByteArrayInputStream clip = new ByteArrayInputStream(stream.getSecond().readAllBytes());
                newMusicList.add(clip);
                newMusicNames.add(stream.getFirst());
            }
            if(checkQueue(newMusicNames)) return;
            endPlayer();
            musicList = newMusicList;
            musicNames = newMusicNames;
            isNewQueue = true;
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

    public static void playNext() {
        if(player != null) {
            player.close();
        }
    }

    public static boolean checkQueue(List<String> list) {
        if(musicNames == null) {
            return false;
        }
        if(list.size() != musicNames.size()) {
            return false;
        }
        for(int i=0; i<list.size(); i++) {
            if(!list.get(i).equals(musicNames.get(i))) {
                return false;
            }
        }
        return true;
    }
}
