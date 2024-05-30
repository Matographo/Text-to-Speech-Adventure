package de.ttsa.Logic.Features.Room;

import java.util.regex.Pattern;

import de.ttsa.Enums.CompilerSyntax;
import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;
import de.ttsa.Logic.Compiler.CompilerSteps.CodeTester;

public class RoomCodeSyntax implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ROOM_CODE.toString());

    @Override
    public boolean testCode(String code) {
        boolean result = pattern.matcher(code).matches();
        if(result) {
            CodeTester.OpCodeVar.addRoomName(code.substring(0, code.indexOf(CompilerSyntax.BLOCK_START.toString())).strip());
        }
        return result;
    }
    
}
