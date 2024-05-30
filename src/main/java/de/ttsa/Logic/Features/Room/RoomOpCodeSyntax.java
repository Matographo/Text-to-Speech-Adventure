package de.ttsa.Logic.Features.Room;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class RoomOpCodeSyntax implements OpCodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ROOM_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        boolean result = pattern.matcher(arg).matches();
        if(result) {
            OpCodeTest.opCodeVar.addRoomName(arg.substring(0, arg.indexOf(Seperators.ROOM.getSeperator())).strip());
        }
        return result;
    }

}
