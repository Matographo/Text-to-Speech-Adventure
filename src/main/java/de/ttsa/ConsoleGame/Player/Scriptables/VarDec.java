package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Functions.Calculator;

public class VarDec implements Scriptable {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String varName;
    private String operation;



// ---------------------------------------------- Constructor ------------------------------------------------- //



    /**
     * Constructor for VarDec
     * @param varName the name of the variable
     * @param operation the operation that should be executed
     */
    public VarDec(String varName, String operation) {
        this.varName   = varName;
        this.operation = operation;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        INT var = GameManager.numVars.get(varName);

        
        if (var == null) {
            throw new RuntimeException("Variable " + varName + " not found!");
        }

        var.setValue(Calculator.calc(operation));
        return true;
    }


    
}
