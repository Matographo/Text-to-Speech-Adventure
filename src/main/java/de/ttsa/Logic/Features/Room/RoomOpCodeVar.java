package de.ttsa.Logic.Features.Room;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class RoomOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(Seperators.ROOM.getSeperator());

        if(opCodeVar.isRoomName(arg[0])) return false;

        opCodeVar.addRoomName(arg[0]);

        return true;
    }
    
}
