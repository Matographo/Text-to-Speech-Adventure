package de.ttsa.Logic.Player.Datatypes;

import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class AlwaysFalseOpCodeTest implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return false;
    }
    
}
