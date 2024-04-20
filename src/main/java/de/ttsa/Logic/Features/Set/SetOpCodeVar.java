package de.ttsa.Logic.Features.Set;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class SetOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String setName = toTest.substring(0, toTest.indexOf(OpCodeSeperators.SET_NAME.getSeperator()));

        if(opCodeVar.isSetName(setName)) return false;

        opCodeVar.addSetName(setName);

        return true;
    }
    
}
