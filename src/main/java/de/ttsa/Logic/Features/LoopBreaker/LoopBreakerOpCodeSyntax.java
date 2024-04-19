package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class LoopBreakerOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
