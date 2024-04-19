package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class StrDecOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(OpCodeSeperators.NUMBER_STRING.getSeperator());


        if(opCodeVar.isVarName(arg[0])) return false;

        opCodeVar.addStrName(arg[0]);

        return true;
    }
    
}
