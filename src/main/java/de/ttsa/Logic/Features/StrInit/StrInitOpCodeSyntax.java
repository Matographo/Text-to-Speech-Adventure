package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class StrInitOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.STR_VARDEC.toString());
    }
    
}
