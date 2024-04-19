package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class RoomJumperOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return opCodeVar.isRoomName(toTest);
    }
    
}
