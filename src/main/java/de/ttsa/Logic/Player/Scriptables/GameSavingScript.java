package de.ttsa.Logic.Player.Scriptables;

import de.ttsa.Logic.Player.GameManager;

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
