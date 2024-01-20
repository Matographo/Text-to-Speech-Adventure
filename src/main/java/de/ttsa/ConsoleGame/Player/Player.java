package de.ttsa.ConsoleGame.Player;

import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class Player {

    private Scriptable game;
    private GameBuilder gameBuilder;

    private final String START_ROOM = "START";


    public Player(String gameFile) {
        this.gameBuilder = new GameBuilder(gameFile);
    }

    public void play() {
        game = gameBuilder.build();
        startGame();
    }

    public static void startGame() {
        GameManager.nextRoom = "START";
        while(GameManager.nextRoom != null) {
            GameManager.getNextRoom().play();
        }
    }
    
}
