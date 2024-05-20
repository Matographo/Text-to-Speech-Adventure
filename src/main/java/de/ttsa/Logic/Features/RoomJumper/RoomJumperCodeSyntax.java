package de.ttsa.Logic.Features.RoomJumper;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class RoomJumperCodeSyntax implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ROOM_JUMPER_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
