package de.ttsa.ConsoleGame.Player.Functions;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class VarDec implements Scriptable {
    
    private String varName;

    private String operation;

    public VarDec(String varName, String operation) {
        this.varName = varName;
        this.operation = operation;
    }

    @Override
    public boolean run() {
        INT var = GameManager.numVars.get(varName);
        if (var == null) {
            throw new RuntimeException("Variable " + varName + " not found!");
        }
        var.setValue(Integer.parseInt(operation));
        return true;
    }
}
