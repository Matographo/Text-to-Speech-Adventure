package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class GameLoaderScript implements Scriptable {

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
