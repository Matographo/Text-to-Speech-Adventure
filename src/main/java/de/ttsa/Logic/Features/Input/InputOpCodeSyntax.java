package de.ttsa.Logic.Features.Input;

import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class InputOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
