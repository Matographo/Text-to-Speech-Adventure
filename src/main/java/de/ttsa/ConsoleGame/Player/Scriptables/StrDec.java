package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;

public class StrDec implements Scriptable {
    
    private String varName;

    private String operation;

    public StrDec(String varName, String operation) {
        this.varName = varName;
        this.operation = operation;
    }

    @Override
    public boolean run() {
        STRING var = GameManager.strVars.get(varName);
        if (var == null) {
            throw new RuntimeException("Variable " + varName + " not found!");
        }
        var.setValue(getValue(operation));
        return true;
    }

    private String getValue(String operation) {
        if(operation.startsWith("\"") && operation.endsWith("\"")) {
            return operation.substring(1, operation.length() - 1);
        } else {
            return GameManager.strVars.get(operation).getValue();
        }
    }
}
