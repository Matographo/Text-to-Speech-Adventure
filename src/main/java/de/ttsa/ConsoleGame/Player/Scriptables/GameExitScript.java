package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class GameExitScript implements Scriptable {
    

// ---------------------------- Attributes ----------------------------



    private boolean saveGame = false;



// --------------------------- Constructor ---------------------------


    /**
     * Constructor for GameExitScript
     * @param arg the argument for the exit game
     */
    public GameExitScript(String arg) {
        if(arg.equals("0")) {
            this.saveGame = false;
        } else if(arg.equals("1")) {
            this.saveGame = true;
        } else {
            throw new IllegalArgumentException("Exit Game Argument must be 0 or 1");
        }
    }



// ----------------------------- Methods -----------------------------



    @Override
    public boolean run() {
        try {
            GameManager.exitGame(saveGame);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
