package de.ttsa.Logic.Features.GameLoaderScript;

import de.ttsa.Logic.Interfaces.Scriptable;
import de.ttsa.Logic.Player.GameManager;

public class GameLoaderScript implements Scriptable {


// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        try {
            GameManager.loadGame();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    
}
