package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class LoopBreakerOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
