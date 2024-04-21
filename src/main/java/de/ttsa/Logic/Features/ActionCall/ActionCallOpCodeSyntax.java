package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class ActionCallOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.ACTION_CALL.toString());
    }
    
}
