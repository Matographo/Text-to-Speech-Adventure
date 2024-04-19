package de.ttsa.Logic.Player.Scriptables;

import de.ttsa.Logic.Player.GameManager;

public class LoopBreaker implements Scriptable {


// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        GameManager.loopBreak = true;
        return true;
    }
    

    
}
