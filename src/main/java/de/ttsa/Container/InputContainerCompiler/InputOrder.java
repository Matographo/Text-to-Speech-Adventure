package de.ttsa.Container.InputContainerCompiler;

import java.util.ArrayList;
import java.util.List;

import de.ttsa.Enums.InputChecker;
import de.ttsa.Interfaces.InputCompilable;
import de.ttsa.Parents.StringMethods;

public class InputOrder extends StringMethods implements InputCompilable {


    List<InputInorder> conditions;

    public InputOrder(String condition) {
        StringBuilder inOrder = new StringBuilder();
        char varType;
        conditions = new ArrayList<>();
        int conditionEnd = 0;


        while(!condition.equals("")) {
            varType = getFirstChar(condition, '\'', '"', '@', '[', '{');
            inOrder.append(condition.substring(0, condition.indexOf(varType)+1));
            condition = condition.substring(condition.indexOf(varType)+1);
            if(varType != InputChecker.VAR.toString().charAt(0)) {
                if(varType == InputChecker.INORDER_START.toString().charAt(0)) {
                    varType = InputChecker.INORDER_END.toString().charAt(0);
                } else if(varType == InputChecker.OFFORDER_START.toString().charAt(0)) {
                    varType = InputChecker.OFFORDER_END.toString().charAt(0);
                } else if(varType == InputChecker.SET.toString().charAt(0)) {
                    varType = InputChecker.SET.toString().charAt(0);
                } else if(varType == InputChecker.STRING.toString().charAt(0)) {
                    varType = InputChecker.STRING.toString().charAt(0);
                }
                conditionEnd = condition.indexOf(varType);
                inOrder.append(condition.substring(0, conditionEnd+1));
                condition = condition.substring(conditionEnd+1);
            } else {
                varType = getFirstChar(condition, '\'', '"', '@', '[', '{');
                conditionEnd = condition.indexOf(varType);
                inOrder.append(condition.substring(0, conditionEnd+1));
                condition = condition.substring(conditionEnd+1);

            }
            varType = getFirstChar(condition, '\'', '"', '@', '[', '{');
            conditionEnd = condition.indexOf(varType);
            if(conditionEnd == -1) {
                conditionEnd = condition.length();
            } else {
                if(condition.charAt(conditionEnd-1) == InputChecker.NOT.toString().charAt(0)) {
                    conditionEnd--;
                }
                if(condition.charAt(conditionEnd-1) == InputChecker.ONLY_MODE.toString().charAt(0)) {
                    conditionEnd--;
                }
                if(condition.charAt(conditionEnd-1) == InputChecker.AND.toString().charAt(0) ||
                   condition.charAt(conditionEnd-1) == InputChecker.OR.toString().charAt(0)) {
                    conditionEnd--;
                }
            }
            inOrder.append(condition.substring(0, conditionEnd));
            condition = condition.substring(conditionEnd);
            /*
            conditionEnd = condition.indexOf(InputChecker.INORDER_END.toString());
            inOrder.append(condition.substring(0, conditionEnd+1));
            condition = condition.substring(conditionEnd+1);

            if(condition.length() > 1) {
                if(condition.startsWith(InputChecker.QUANTOR.toString())) {
                    inOrder.append(InputChecker.QUANTOR.toString());
                    condition = condition.substring(1);
                    if(condition.startsWith("(")) {
                        conditionEnd = condition.indexOf(")");
                        inOrder.append(condition.substring(0, conditionEnd+1));
                        condition = condition.substring(conditionEnd+1);
                    } else {
                        inOrder.append(getFirstNumbers(condition));
                        condition = deleteFirstNumbers(condition);
                    }
                }
            }*/
            conditions.add(new InputInorder(inOrder.toString()));
            inOrder = new StringBuilder();
        }
    }


    @Override
    public String compile() {
        StringBuilder compiled = new StringBuilder();
        for (InputInorder inputInorder : conditions) {
            compiled.append(inputInorder.compile());
        }
        return compiled.toString();
    }
    
}
