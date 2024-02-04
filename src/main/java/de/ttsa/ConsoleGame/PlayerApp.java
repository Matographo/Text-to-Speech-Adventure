package de.ttsa.ConsoleGame;

import de.ttsa.ConsoleGame.Player.Player;

public class PlayerApp {
    

// -------------------------- Main Method --------------------------



    public static void main(String[] args) {
        new PlayerApp().start(args[0]);
    }



// ----------------------- Start of Player -----------------------



    private void start(String path) {
        Player player = new Player(path);
        player.play();
    }


}
