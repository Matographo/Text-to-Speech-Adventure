package de.ttsa.Container.InputContainerCompiler;

import java.util.ArrayList;
import java.util.List;

import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Interfaces.InputCompilable;
import de.ttsa.Logic.Features.Input.Input;
import de.ttsa.Parents.StringMethods;

public class InputOfforder extends StringMethods implements InputCompilable {

    char boolOperator;
    boolean isNot;
    Range occurance;

    List<InputVar> condition;

    public InputOfforder(String condition) {
        int varIndex;
        char varType;
        int conditionEnd;
        StringBuilder varOrder = new StringBuilder();
        this.condition = new ArrayList<>();


        if(condition.startsWith(InputChecker.AND.toString()) ||
           condition.startsWith(InputChecker.OR.toString())) {
            this.boolOperator = condition.charAt(0);
            condition = condition.substring(1);
        }

        if(getFirstChar(condition, '\'', '"', '@', '[', '{') == InputChecker.OFFORDER_START.toString().charAt(0)) {
            if(condition.startsWith(InputChecker.NOT.toString())) {
                this.isNot = true;
                condition = condition.substring(1);
            }
            if(condition.contains(InputChecker.QUANTOR.toString())) {
                String quantor = condition.substring(condition.lastIndexOf(InputChecker.QUANTOR.toString()));
                if(!quantor.contains(InputChecker.OFFORDER_END.toString())) {
                    this.occurance = new Range(condition.substring(condition.indexOf(InputChecker.QUANTOR.toString())));
                    condition = condition.substring(0, condition.indexOf(InputChecker.QUANTOR.toString()));
                }
            } 
            if(this.occurance == null) {
                this.occurance = new Range();
            }
            condition = deleteFirstAndLast(InputChecker.OFFORDER_START.toString(), InputChecker.OFFORDER_END.toString(), condition);
        } else {
            this.occurance = new Range();
        }
        
        
        
        while(!condition.equals("")) {
            varType = getFirstChar(condition, '"', '\'', '@');
            varOrder.append(condition.substring(0, condition.indexOf(varType)+1));
            condition = condition.substring(condition.indexOf(varType)+1);
            //varOrder.append(varType);
            if(varType == InputChecker.SET.toString().charAt(0) || 
                varType == InputChecker.STRING.toString().charAt(0)) {
                varOrder.append(condition.substring(0, condition.indexOf(varType)+1));
                condition = condition.substring(condition.indexOf(varType)+1);
            } else if(varType == InputChecker.VAR.toString().charAt(0)) {
                int varEnd = 0;
                varEnd = condition.indexOf(getFirstChar(condition, '"', '\'', '@', '[', '{'));
                if(varEnd == -1) {
                    varEnd = condition.length();
                } else {
                    if (condition.charAt(varEnd-1) == InputChecker.NOT.toString().charAt(0)) {
                        varEnd--;
                    }
                    if(condition.charAt(varEnd-1) == InputChecker.AND.toString().charAt(0) ||
                       condition.charAt(varEnd-1) == InputChecker.OR.toString().charAt(0)) {
                        varEnd--;
                    }
                }
                varOrder.append(condition.substring(0, varEnd));
                condition = condition.substring(varEnd);
                this.condition.add(new InputVar(varOrder.toString()));
                varOrder = new StringBuilder();
                continue;
            } else {
                throw new IllegalArgumentException("Invalid Input compilation");
            }
            varType = getFirstChar(condition, '"', '\'', '@');
            conditionEnd = condition.indexOf(varType);
            if(condition.startsWith(InputChecker.QUANTOR.toString())) {
                if(condition.charAt(1) == '(') {
                    varIndex = condition.indexOf(")");
                    varOrder.append(condition.substring(0, varIndex+1));
                    condition = condition.substring(varIndex+1);
                } else {
                    varOrder.append(InputChecker.QUANTOR.toString());
                    condition = condition.substring(1);
                    varOrder.append(getFirstNumbers(condition));
                    condition = deleteFirstNumbers(condition);
                }
            }
            this.condition.add(new InputVar(varOrder.toString()));
            varOrder = new StringBuilder();
        }
    }

    @Override
    public String compile() {
        StringBuilder compiled = new StringBuilder();
        if(this.boolOperator != 0) {
            compiled.append(this.boolOperator);
        }
        if(this.isNot) {
            compiled.append(InputChecker.NOT.toString());
        }
        compiled.append(InputChecker.OFFORDER_START.toString());
        compiled.append(getVarContent(condition));
        compiled.append(InputChecker.OFFORDER_END.toString());
        
        compiled.append(occurance.toString());

        return compiled.toString();
    }

    private String getVarContent(List<InputVar> conditions) {
        StringBuilder compiled = new StringBuilder();
        for (int i = 0; i < conditions.size(); i++) {
            compiled.append(conditions.get(i).compile());
        }
        return compiled.toString();
    }
}
