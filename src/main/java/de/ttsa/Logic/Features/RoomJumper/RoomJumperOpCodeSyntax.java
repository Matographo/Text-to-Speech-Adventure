package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class RoomJumperOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.ROOM_JUMPER.toString());
    }

}
