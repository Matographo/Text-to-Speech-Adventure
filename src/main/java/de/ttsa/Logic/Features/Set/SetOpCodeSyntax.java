package de.ttsa.Logic.Features.Set;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class SetOpCodeSyntax extends OpCode implements OpCodeTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_SET);
    }
    
}
