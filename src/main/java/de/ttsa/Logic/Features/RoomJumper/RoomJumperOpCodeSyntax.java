package de.ttsa.Logic.Features.RoomJumper;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class RoomJumperOpCodeSyntax implements OpCodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ROOM_JUMPER_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }

}
