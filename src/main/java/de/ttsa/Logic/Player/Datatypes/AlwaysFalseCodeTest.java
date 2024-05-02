package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class AlwaysFalseCodeTest implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return false;
    }
    
}
