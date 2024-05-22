package de.ttsa.Logic.Features.MusicStarter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.Player.Functions.PlayerFunctions.MusicPlayer;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Tools.ZipManager;

public class MusicStarter implements Scriptable {
    
    private List<String> musicList;

    public MusicStarter(String args) {
        musicList = new LinkedList<>();
        String[] musicFiles = args.split(Seperators.MUSIC_STARTER.getSeperator());
        for (String musicFile : musicFiles) {
            musicList.add(musicFile);
        }
    }

    @Override
    public boolean run() {
        try {
            MusicPlayer.setMusicList(getMusicFiles());
            MusicPlayer.playMusic();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private List<InputStream> getMusicFiles() {
        List<String> musicList = new ArrayList<>();
        for(String musicFile : this.musicList) {
            musicList.add(GameManager.music.get(musicFile));
        }
        return ZipManager.getMusicFiles(GameManager.gameFile.getAbsolutePath(), musicList);
    }
}
