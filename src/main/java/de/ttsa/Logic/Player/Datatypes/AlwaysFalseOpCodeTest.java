package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

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
