package de.ttsa.Logic.Features.Input;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class InputOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
