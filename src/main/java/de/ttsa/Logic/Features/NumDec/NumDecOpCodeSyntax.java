package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class NumDecOpCodeSyntax extends OpCode implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_NUMBER_VARIABLE);
    }
    
}
