package de.ttsa.ConsoleGame;

import java.io.IOException;

import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.Stats.BuildingStats;

public class PlayerApp {
    

// -------------------------- Main Method --------------------------



    public static void main(String[] args) throws IOException, InterruptedException {
        new PlayerApp().start(args[0]);
    }



// ----------------------- Start of Player -----------------------



    public void start(String path) {
        Player player = new Player(path);
        player.play();
    }


}
