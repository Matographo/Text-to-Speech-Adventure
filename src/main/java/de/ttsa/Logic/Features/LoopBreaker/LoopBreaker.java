package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;

public class LoopBreaker implements Scriptable {


// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        GameManager.loopBreak = true;
        return true;
    }
    

    
}
