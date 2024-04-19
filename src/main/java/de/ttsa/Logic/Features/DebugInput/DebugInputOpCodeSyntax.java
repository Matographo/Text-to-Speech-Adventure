package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class DebugInputOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {
    
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_DEBUG);
    }
    
}
