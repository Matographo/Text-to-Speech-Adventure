package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class StrDecOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(OpCodeSeperators.NUMBER_STRING.getSeperator());


        if(opCodeVar.isVarName(arg[0])) return false;

        opCodeVar.addStrName(arg[0]);

        return true;
    }
    
}
