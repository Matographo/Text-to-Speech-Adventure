package de.ttsa.ConsoleGame.Player.Functions;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class DebugInput implements Scriptable {


    private String input;

    public DebugInput(String input) {
        this.input = input;
    }

    @Override
    public boolean run() {
        if(input == null) return false;
        if(input.startsWith("\"") && input.endsWith("\"")) {
            input = input.substring(1, input.length() - 1);
        } else {
            input = GameManager.strVars.get(input).getValue();
        }
        GameManager.input = input;
        return true;
    }
    

}