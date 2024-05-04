package de.ttsa.Logic.Features.Room;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class RoomCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.ROOM_CODE.toString());
    }
    
}
