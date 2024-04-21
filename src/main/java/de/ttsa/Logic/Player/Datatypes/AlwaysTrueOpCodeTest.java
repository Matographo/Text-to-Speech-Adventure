package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class AlwaysTrueOpCodeTest implements OpCodeSyntaxTestable, OpCodeVarTestable {

    @Override
    public boolean testOpCode(String arg) {
        return true;
    }

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return true;
    }

}
