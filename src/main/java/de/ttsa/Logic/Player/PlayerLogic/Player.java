package de.ttsa.Logic.Player.PlayerLogic;

import java.io.FileInputStream;

import de.ttsa.Logic.Player.Functions.PlayerFunctions.MusicPlayer;

public class Player {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private GameBuilder gameBuilder;

    private static final String START_ROOM = "START";



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for Player
     * @param file the path to the game
     */
    public Player(String file) {
        this.gameBuilder = new GameBuilder(file);
    }

    /**
     * Constructor for Player
     * @param gameBuilder the game builder
     */
    public void play() {
        buildGame();
        startGame();
    }

    public void buildGame() {
        gameBuilder.build();
    }

    public void playGame(boolean isTerminalGame) {
        GameManager.isTerminalGame = isTerminalGame;
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
        MusicPlayer.endPlayer();
    }


    public static String getHelp() {
        return "[File Path]";
    }
    
    
}
