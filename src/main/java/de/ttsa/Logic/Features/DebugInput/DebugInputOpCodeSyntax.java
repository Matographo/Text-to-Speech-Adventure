package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class DebugInputOpCodeSyntax extends OpCode implements OpCodeTestable {
    
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_DEBUG);
    }
    
}
