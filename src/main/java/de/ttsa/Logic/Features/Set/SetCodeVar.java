package de.ttsa.Logic.Features.Set;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class SetCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return opCodeVar.addSetName(toTest.substring(0, toTest.indexOf("{")).strip());
    }
    
}
