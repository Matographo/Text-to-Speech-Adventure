package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Enums.Index;
import de.ttsa.Parents.CompilerLineMethods;

public class RoomJumperCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(Index.ROOM_JUMPER);
        compiled.append(commands);
        return compiled.toString();
    }
    
}
