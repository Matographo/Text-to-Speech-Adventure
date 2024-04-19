package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class StrInitOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_STR_VARDEC);
    }
    
}
