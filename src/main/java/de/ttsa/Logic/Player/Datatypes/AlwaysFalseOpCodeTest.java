package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class AlwaysFalseOpCodeTest implements OpCodeSyntaxTestable, OpCodeVarTestable {

    @Override
    public boolean testOpCode(String arg) {
        return false;
    }

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return false;
    }
    
}
