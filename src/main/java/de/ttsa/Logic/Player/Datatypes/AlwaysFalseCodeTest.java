package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Interfaces.CodeVarTestable;

public class AlwaysFalseCodeTest implements CodeSyntaxTestable, CodeVarTestable {

    @Override
    public boolean testCode(String code) {
        return false;
    }

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return false;
    }
    
}
