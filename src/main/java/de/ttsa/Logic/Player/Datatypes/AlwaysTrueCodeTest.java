package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class AlwaysTrueCodeTest implements CodeVarTestable{

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return true;
    }
    
}
