package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class LoopBreaker implements Scriptable {

    @Override
    public boolean run() {
        GameManager.loopBreak = true;
        return true;
    }
    
}
