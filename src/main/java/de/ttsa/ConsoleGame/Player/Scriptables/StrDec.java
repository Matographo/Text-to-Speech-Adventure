package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;

public class StrDec implements Scriptable {
    

// ---------------------------- Attributes ----------------------------



    private String varName;
    private String operation;



// --------------------------- Constructors ---------------------------


    /**
     * Constructor for StrDec
     * @param varName the name of the variable
     * @param operation the operation
     */
    public StrDec(String varName, String operation) {
        this.varName   = varName;
        this.operation = operation;
    }



// ----------------------------- Methods -----------------------------



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
        if(operation.startsWith("\"") && operation.endsWith("\"")) {
            return operation.substring(1, operation.length() - 1);
        } else {
            return GameManager.strVars.get(operation).getValue();
        }
    }


}
