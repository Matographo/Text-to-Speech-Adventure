package de.ttsa.Interfaces;

public interface MusicPlayable {
    
    void play();
    void stop();
    void setVolume(int volumePercentage);
    boolean isRunning();
}
