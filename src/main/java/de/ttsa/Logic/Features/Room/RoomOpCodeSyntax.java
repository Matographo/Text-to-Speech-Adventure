package de.ttsa.Logic.Features.Room;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class RoomOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_ROOM);
    }

}
