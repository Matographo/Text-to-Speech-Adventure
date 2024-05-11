package de.ttsa.Logic.Features.Action;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Parents.StringMethods;

public class ActionCodeVar extends StringMethods implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        boolean result = true;
        String actionName = toTest.substring(0, toTest.indexOf("(")).strip();
        String[] actionArgs = toTest.substring(toTest.indexOf("(") + 1, toTest.indexOf(")")).split(",");

        if(!opCodeVar.addActionNameCode(actionName)) return false;

        String argType;
        String argName;

        for(String arg : actionArgs) {
            if(arg.isBlank()) continue;
            arg     = arg.strip();
            argType = arg.substring(0, arg.indexOf(" ")).strip();
            argName = arg.substring(arg.indexOf(" ") + 1).strip();

            if(argType.equals(CompilerSyntax.NUM_DEC.toString())) {
                result &= opCodeVar.addActionArgsCode(actionName,argName) && opCodeVar.addNumName(argName);
            } else if(argType.equals(CompilerSyntax.STR_DEC.toString())) {
                result &= opCodeVar.addActionArgsCode(actionName,argName) && opCodeVar.addStrName(argName);
            } else {
                result &= false;
            }
        }
        return result;
    }
    
}
