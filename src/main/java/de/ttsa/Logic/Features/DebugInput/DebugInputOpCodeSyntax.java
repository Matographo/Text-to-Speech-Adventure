package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class DebugInputOpCodeSyntax implements OpCodeSyntaxTestable {
    
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.DEBUG.toString());
    }
    
}
