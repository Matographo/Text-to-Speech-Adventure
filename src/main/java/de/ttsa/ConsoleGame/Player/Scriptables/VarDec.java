package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Functions.Calculator;

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
        Calculator calc = new Calculator();
        if (var == null) {
            throw new RuntimeException("Variable " + varName + " not found!");
        }
        var.setValue(calc.calc(operation));
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
