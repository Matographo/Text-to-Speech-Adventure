package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class GameSavingScript implements Scriptable {


// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        try {
        GameManager.saveGame();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    

    
}
