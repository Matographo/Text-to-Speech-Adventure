package de.ttsa.Container.InputContainerCompiler;

import java.util.ArrayList;
import java.util.List;

import de.ttsa.Container.Range;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Interfaces.InputCompilable;
import de.ttsa.Parents.StringMethods;

public class InputInorder extends StringMethods implements InputCompilable {

    char boolOperator;
    boolean onlyMode;
    boolean isNot;
    Range occurance;

    List<InputOfforder> conditions;

    public InputInorder(String condition) {
        int offorderIndex;
        char varType;
        int conditionEnd;
        StringBuilder offOrder = new StringBuilder();
        conditions = new ArrayList<>();


        if(condition.startsWith(InputChecker.AND.toString()) ||
           condition.startsWith(InputChecker.OR.toString())) {
            this.boolOperator = condition.charAt(0);
            condition = condition.substring(1);
        }
        if(condition.startsWith(InputChecker.ONLY_MODE.toString())) {
            this.onlyMode = true;
            condition = condition.substring(1);
        }

        if(getFirstChar(condition, '\'', '"', '@', '{', '[') == InputChecker.INORDER_START.toString().charAt(0)) {
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
            condition = deleteFirstAndLast(InputChecker.INORDER_START.toString(), InputChecker.INORDER_END.toString(), condition);
        } else {
            this.occurance = new Range();
        }
        
        while(!condition.equals("")) {
            varType = getFirstChar(condition, '\'', '"', '@', '{');
            if(varType == InputChecker.OFFORDER_START.toString().charAt(0)) {
                conditionEnd = condition.indexOf(InputChecker.OFFORDER_END.toString());
                offOrder.append(condition.substring(0, conditionEnd+1));
                condition = condition.substring(conditionEnd+1);
            } else {
                if(varType == InputChecker.VAR.toString().charAt(0)) {
                    offOrder.append(condition.substring(0, condition.indexOf(varType)+1));
                    condition = condition.substring(condition.indexOf(varType)+1);
                    varType = getFirstChar(condition.substring(1), '\'', '"', '@', '{');
                    conditionEnd = condition.indexOf(varType);
                } else {
                    offOrder.append(condition.substring(0, condition.indexOf(varType)+1));
                    condition = condition.substring(condition.indexOf(varType)+1);
                    conditionEnd = condition.indexOf(varType)+1;
                }
                if(conditionEnd == -1) {
                    conditionEnd = condition.length();
                }
                offOrder.append(condition.substring(0, conditionEnd));
                condition = condition.substring(conditionEnd);
                varType = getFirstChar(condition, '\'', '"', '@', '{');
                conditionEnd = condition.indexOf(varType);
                if(conditionEnd == -1) {
                    conditionEnd = condition.length();
                }
                if(conditionEnd > 0 && condition.charAt(conditionEnd-1) == InputChecker.NOT.toString().charAt(0)) {
                    conditionEnd--;
                }
                if(conditionEnd > 0 && (condition.charAt(conditionEnd-1) == InputChecker.AND.toString().charAt(0) ||
                   condition.charAt(conditionEnd-1) == InputChecker.OR.toString().charAt(0))) {
                    conditionEnd--;
                }
                offOrder.append(condition.substring(0, conditionEnd));
                condition = condition.substring(conditionEnd);
            }
            conditions.add(new InputOfforder(offOrder.toString()));
            offOrder = new StringBuilder();
        }
    }

    @Override
    public String compile() {
        StringBuilder compiled = new StringBuilder();
        if(this.boolOperator != 0) {
            compiled.append(this.boolOperator);
        }
        if(this.onlyMode) {
            compiled.append(InputChecker.ONLY_MODE.toString());
        }
        if(this.isNot) {
            compiled.append(InputChecker.NOT.toString());
        }
        compiled.append(InputChecker.INORDER_START.toString());
        compiled.append(getOffOrderContent(conditions));
        compiled.append(InputChecker.INORDER_END.toString());

        compiled.append(occurance.toString());

        return compiled.toString();
    }

    private String getOffOrderContent(List<InputOfforder> conditions) {
        StringBuilder compiled = new StringBuilder();
        for (int i = 0; i < conditions.size(); i++) {
            compiled.append(conditions.get(i).compile());
        }
        return compiled.toString();
    }
    
}
