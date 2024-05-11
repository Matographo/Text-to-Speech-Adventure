package de.ttsa.Logic.Features.ActionCall;

import java.util.List;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class ActionCallCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.strip();
        boolean result = true;


        if(!toTest.contains(" ")) {
            if(opCodeVar.isActionName(toTest)) return true;
            return opCodeVar.getActionArgsCode(toTest).size() != 0;
        }


        String actionName = toTest.substring(0, toTest.indexOf(" ")).strip();
        toTest = toTest.substring(toTest.indexOf(" ") + 1).strip();
        String[] actionCallArgs = toTest.split(",");
        List<String> actionArgs = opCodeVar.getActionArgsCode(actionName);
        boolean isNumber;
        if(actionCallArgs.length != actionArgs.size()) return false;
        for(int i=0; i<actionCallArgs.length; i++) {
            actionCallArgs[i] = actionCallArgs[i].strip();
            isNumber = opCodeVar.isNumName(actionArgs.get(i));
            if(isNumber) {
                result &= (actionCallArgs[i].matches("\\d+") || opCodeVar.isNumName(actionCallArgs[i]));
            } else {
                result &= actionCallArgs[i].matches("\"\\w+\"") || opCodeVar.isStrName(actionCallArgs[i]);
            }
        }
        return result;
    }
    
}
