package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class ActionCallOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_ACTION_CALL);
    }
    
}
