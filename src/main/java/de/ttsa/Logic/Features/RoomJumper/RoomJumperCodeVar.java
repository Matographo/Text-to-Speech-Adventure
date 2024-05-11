package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class RoomJumperCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        return opCodeVar.isRoomName(toTest);
    }
    
}
