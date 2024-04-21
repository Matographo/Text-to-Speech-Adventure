package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class NumDecOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.NUMBER_DEC.toString());
    }
    
}
