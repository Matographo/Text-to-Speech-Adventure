package de.ttsa.Logic.Features.Room;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeVar;
import de.ttsa.Logic.Enums.OpCodeSeperators;
import de.ttsa.Logic.Interfaces.OpCodeVarTestable;

public class RoomOpCodeVar implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(OpCodeSeperators.ROOM.getSeperator());

        if(opCodeVar.isRoomName(arg[0])) return false;

        opCodeVar.addRoomName(arg[0]);

        return true;
    }
    
}
