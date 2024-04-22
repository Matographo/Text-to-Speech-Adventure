package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class DebugInputOpCodeSyntax implements OpCodeSyntaxTestable {
    
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.DEBUG.toString());
    }
    
}
