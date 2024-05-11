package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Parents.StringMethods;

public class DebugInputCodeVar extends StringMethods implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String varTest;
        while(toTest.contains("'")) {
            varTest = getNextSubstring("'", toTest);
            if(!opCodeVar.isStrName(varTest)) return false;
            toTest = deleteUntilAfterSubstring("'", varTest); 
        }
        return true;
    }
    
}
