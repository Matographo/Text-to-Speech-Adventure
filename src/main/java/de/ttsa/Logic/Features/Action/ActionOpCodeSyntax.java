package de.ttsa.Logic.Features.Action;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class ActionOpCodeSyntax extends OpCode implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_ACTION);
    }
    
}
