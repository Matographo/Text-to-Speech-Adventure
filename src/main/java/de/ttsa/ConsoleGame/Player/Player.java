package de.ttsa.ConsoleGame.Player;

public class Player {

    private GameBuilder gameBuilder;

    private static final String START_ROOM = "START";


    public Player(String gameFile) {
        this.gameBuilder = new GameBuilder(gameFile);
    }

    public void play() {
        gameBuilder.build();
        startGame();
    }

    public static void startGame() {
        GameManager.running = true;
        GameManager.nextRoom = START_ROOM;
        while(GameManager.nextRoom != null && GameManager.running) {
            GameManager.getNextRoom().play();
        }
    }
    
}
