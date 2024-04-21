package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class RoomJumperOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return opCodeVar.isRoomName(toTest);
    }
    
}
