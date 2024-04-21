package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class StrInitOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.STR_VARDEC.toString());
    }
    
}
