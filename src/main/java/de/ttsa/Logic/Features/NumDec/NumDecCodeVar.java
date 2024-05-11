package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class NumDecCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        if(toTest.contains("=")) {
            toTest = toTest.substring(0, toTest.indexOf("=")).strip();
        } else if(toTest.contains(" ")) {
            toTest = toTest.substring(0, toTest.indexOf(" ")).strip();
        } else {
            toTest = toTest.strip();
        }

        return opCodeVar.addNumName(toTest);
    }
    
}
