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
        if(isNumber(operation)) {
            var.setValue(Integer.parseInt(operation));
        } else if (isValidName(operation) && GameManager.numVars.get(operation) != null) {
            var.setValue(GameManager.numVars.get(operation).getValue());
        } else {
            throw new RuntimeException("Invalid operation!");
        }
        return true;
    }

    private boolean isValidName(String name) {
        if(Character.isDigit(name.charAt(0))) {
            return false;
        } else if (name.contains(" ")) {
            return false;
        } else if (!name.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String number) {
        if(number.matches("\\d+")) {
            return true;
        }
        return false;
    }
}
