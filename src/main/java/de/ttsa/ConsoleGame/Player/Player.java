package de.ttsa.ConsoleGame.Player;

import java.util.ArrayList;

public class Player {


// ---------------------------- Attributes ----------------------------



    private GameBuilder gameBuilder;

    private static final String START_ROOM = "START";



// ----------------------------- Constructor -----------------------------


    /**
     * Constructor for Player
     * @param gameFile the path to the game
     */
    public Player(String gameFile) {
        this.gameBuilder = new GameBuilder(gameFile);
    }

    /**
     * Constructor for Player
     * @param gameBuilder the game builder
     */
    public void play() {
        gameBuilder.build();
        startGame();
    }

    public void playGame() {
        GameManager.isTerminalGame = false;
        play();
    }

    /**
     * Start the game
     */
    private void startGame() {
        GameManager.running  = true;
        GameManager.nextRoom = START_ROOM;


        while(GameManager.nextRoom != null && GameManager.running) {
            GameManager.getNextRoom().play();
        }
    }

    public void makeInput(String input) {
        if(input != null && !input.isEmpty()) {
            GameManager.isMakedInput = true;
            GameManager.input = input;
        }
    }

    public ArrayList<String> getOutput() {
        ArrayList<String> output = new ArrayList<>(GameManager.output);
        GameManager.output.clear();
        return output;
    }
    
    
}
