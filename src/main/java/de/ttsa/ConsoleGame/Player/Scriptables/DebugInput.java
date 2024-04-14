package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

public class DebugInput implements Scriptable {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String input;



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for DebugInput
     * @param input the input that should be set
     */
    public DebugInput(String input) {
        this.input = input;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        if(input == null) return false;

        GameManager.input = getInputString();
        return true;
    }

    private String getInputString() {
        StringBuilder result = new StringBuilder();
        String[] parts = input.split(",");
        for(String part : parts) {
            if(part.startsWith("\"") && part.endsWith("\"")) {
                result.append(part.substring(1, part.length() - 1));
            } else {
                result.append(GameManager.strVars.get(part).getValue());
            }
        }

        return result.toString();
    }
    

}
