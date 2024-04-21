package de.ttsa.Logic.Features.GameSavingScript;

import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;

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
