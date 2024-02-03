package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class DebugInput implements Scriptable {


// ---------------------------- Attributes ----------------------------



    private String input;



// --------------------------- Constructor ---------------------------


    /**
     * Constructor for DebugInput
     * @param input the input that should be set
     */
    public DebugInput(String input) {
        this.input = input;
    }



// ----------------------------- Methods -----------------------------



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
