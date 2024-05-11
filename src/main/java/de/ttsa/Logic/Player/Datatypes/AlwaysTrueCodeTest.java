package de.ttsa.Logic.Player.Datatypes;

import java.util.List;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeBlockTestable;
import de.ttsa.Interfaces.CodeVarTestable;

public class AlwaysTrueCodeTest implements CodeVarTestable, CodeBlockTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return true;
    }

    @Override
    public int testCode(String args, List<String> lines) {
        return 0;
    }
    
}
