package de.ttsa.Logic.Features.Room;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class RoomOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.ROOM.toString());
    }

}
