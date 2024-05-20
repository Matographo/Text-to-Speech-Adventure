package de.ttsa.Logic.Features.DebugInput;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class DebugInputOpCodeSyntax implements OpCodeSyntaxTestable {
    
    private static Pattern pattern = Pattern.compile(Regex.DEBUG_OPCODE.toString());

    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
