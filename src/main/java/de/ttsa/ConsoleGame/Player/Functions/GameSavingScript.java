package de.ttsa.ConsoleGame.Player.Functions;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class GameSavingScript implements Scriptable {

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
