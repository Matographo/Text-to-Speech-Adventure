package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class ActionCallOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.ACTION_CALL.toString());
    }
    
}
