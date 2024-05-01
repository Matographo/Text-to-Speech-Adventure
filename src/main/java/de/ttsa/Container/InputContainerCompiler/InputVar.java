package de.ttsa.Container.InputContainerCompiler;

import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Interfaces.InputCompilable;

public class InputVar implements InputCompilable {

    char boolOperator;
    char varType;
    boolean isNot;
    Range occurance;

    String condition;

    public InputVar(String condition) {
        if(condition.startsWith(InputChecker.AND.toString()) ||
           condition.startsWith(InputChecker.OR.toString())) {
            this.boolOperator = condition.charAt(0);
            condition = condition.substring(1);
        }
        if(condition.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            condition = condition.substring(1);
        }
        if(condition.contains(InputChecker.QUANTOR.toString())) {
            this.occurance = new Range(condition.substring(condition.indexOf(InputChecker.QUANTOR.toString())));
            condition = condition.substring(0, condition.indexOf(InputChecker.QUANTOR.toString()));
        } else {
            this.occurance = new Range();
        }

        if(condition.startsWith(InputChecker.VAR.toString())) {
            this.varType = InputChecker.VAR.toString().charAt(0);
            this.condition = condition.substring(1);
        } else if (condition.startsWith(InputChecker.SET.toString())) {
            this.varType = InputChecker.SET.toString().charAt(0);
            this.condition = condition.substring(1, condition.length()-1);
        } else if (condition.startsWith(InputChecker.STRING.toString())) {
            this.varType = InputChecker.STRING.toString().charAt(0);
            this.condition = condition.substring(1, condition.length()-1);
        }

    }

    @Override
    public String compile() {
        StringBuilder compiled = new StringBuilder();
        
        if(boolOperator != 0) {
            compiled.append(boolOperator);
        }
        if(isNot) {
            compiled.append(InputChecker.NOT);
        }

        compiled.append(varType);
        compiled.append(condition);
        compiled.append(varType);

        compiled.append(occurance.toString());

        return compiled.toString();
    }

}
