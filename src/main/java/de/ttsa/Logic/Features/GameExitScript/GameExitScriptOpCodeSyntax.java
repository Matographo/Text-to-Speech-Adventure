package de.ttsa.Logic.Features.GameExitScript;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class GameExitScriptOpCodeSyntax implements OpCodeSyntaxTestable {
        
    private static Pattern pattern = Pattern.compile(Regex.EXIT_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
