package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class StrDecOpCodeSyntax extends OpCode implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_STRING_VARIABLE);
    }
    
}
