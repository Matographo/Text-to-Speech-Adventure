package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class StrDecOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.STR_DEC.toString());
    }
    
}
