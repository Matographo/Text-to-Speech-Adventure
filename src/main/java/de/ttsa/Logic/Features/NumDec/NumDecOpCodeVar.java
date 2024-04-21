package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.OpCodeSeperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class NumDecOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(OpCodeSeperators.NUMBER_VARIABLE.getSeperator());


        if(opCodeVar.isVarName(arg[0])) return false;

        opCodeVar.addNumName(arg[0]);

        return true;
    }
    
}
