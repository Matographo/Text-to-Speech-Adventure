package de.ttsa.ConsoleGame;

import de.ttsa.ConsoleGame.Player.Player;

public class PlayerApp {
    

// -------------------------- Main Method --------------------------



    public static void main(String[] args) {
        new PlayerApp().start(args);
    }



// ----------------------- Start of Player -----------------------



    public void start(String[] args) {
        long start = System.currentTimeMillis();
        Player player = new Player(args[0]);
        player.play();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }


}
