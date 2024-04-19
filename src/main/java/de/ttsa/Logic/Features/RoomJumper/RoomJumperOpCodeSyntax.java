package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class RoomJumperOpCodeSyntax extends OpCode implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_ROOM_JUMPER);
    }

}
