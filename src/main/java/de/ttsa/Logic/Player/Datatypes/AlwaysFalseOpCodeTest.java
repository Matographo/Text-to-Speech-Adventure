package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class AlwaysFalseOpCodeTest implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return false;
    }
    
}
