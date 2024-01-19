package de.ttsa.ConsoleGame.Player;

import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class Player {

    private Scriptable game;
    private GameBuilder gameBuilder;


    public Player(String gameFile) {
        this.gameBuilder = new GameBuilder(gameFile);
    }

    public void play() {
        game = gameBuilder.build();
        start();
    }

    private void start() {
        game.run();
    }
    
}
