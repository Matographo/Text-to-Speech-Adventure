package de.ttsa.Logic.Features.Room;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Interfaces.CodeVarTestable;

public class RoomCodeVar implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.substring(0, toTest.indexOf(CompilerSyntax.BLOCK_START.toString())).strip();
        return opCodeVar.addRoomName(toTest);
    }
    
}
