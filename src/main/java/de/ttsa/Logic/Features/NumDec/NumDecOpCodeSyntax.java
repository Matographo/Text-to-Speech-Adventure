package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class NumDecOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_NUMBER_VARIABLE);
    }
    
}
