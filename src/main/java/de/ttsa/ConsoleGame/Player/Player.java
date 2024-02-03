package de.ttsa.ConsoleGame.Player;

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

    /**
     * Start the game
     */
    public static void startGame() {
        GameManager.running  = true;
        GameManager.nextRoom = START_ROOM;


        while(GameManager.nextRoom != null && GameManager.running) {
            GameManager.getNextRoom().play();
        }
    }
    
    
}
