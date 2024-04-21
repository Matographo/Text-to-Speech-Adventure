package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.Player.Datatypes.STRING;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;

public class StrInit implements Scriptable {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String varName;
    private String operation;



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Constructor for StrDec
     * @param varName the name of the variable
     * @param operation the operation
     */
    public StrInit(String varName, String operation) {
        this.varName   = varName;
        this.operation = operation;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        STRING var = GameManager.strVars.get(varName);
        if (var == null) {
            throw new RuntimeException("Variable " + varName + " not found!");
        }
        var.setValue(getValue(operation));
        return true;
    }

    /**
     * Get the value of the operation
     * @param operation the operation
     * @return the value
     */
    private String getValue(String operation) {
        StringBuilder result = new StringBuilder();
        String[] parts = operation.split(",");
        for (String part : parts) {
            if (part.startsWith("\"") && part.endsWith("\"")) {
                result.append(part.substring(1, part.length() - 1));
            } else {
                result.append(GameManager.strVars.get(part).getValue());
            }
        }
        return result.toString();
    }


}
