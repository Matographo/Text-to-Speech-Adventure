package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class StrDecOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.STR_DEC_OPCODE.toString());
    }
    
}
