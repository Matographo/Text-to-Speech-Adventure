package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class RoomJumperCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.ROOM_JUMPER_CODE.toString());
    }
    
}
