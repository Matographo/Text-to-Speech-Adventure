package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;

public class RoomJumperCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(OpCodeIndex.ROOM_JUMPER);
        compiled.append(commands);
        return compiled.toString();
    }
    
}
