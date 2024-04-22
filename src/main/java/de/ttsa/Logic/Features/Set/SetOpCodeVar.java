package de.ttsa.Logic.Features.Set;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class SetOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String setName = toTest.substring(0, toTest.indexOf(Seperators.SET_NAME.getSeperator()));

        if(opCodeVar.isSetName(setName)) return false;

        opCodeVar.addSetName(setName);

        return true;
    }
    
}
