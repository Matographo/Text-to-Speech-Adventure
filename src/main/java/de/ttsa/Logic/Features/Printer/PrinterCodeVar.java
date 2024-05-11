package de.ttsa.Logic.Features.Printer;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;
import de.ttsa.Parents.StringMethods;

public class PrinterCodeVar extends StringMethods implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String varTest;
        while(toTest.contains("'")) {
            varTest = getNextSubstring("'", toTest);
            if(!opCodeVar.isVarName(varTest)) return false;
            toTest = deleteUntilAfterSubstring("'", varTest); 
        }
        return true;
    }
    
}
