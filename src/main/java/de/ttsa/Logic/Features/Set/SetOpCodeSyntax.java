package de.ttsa.Logic.Features.Set;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class SetOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_SET);
    }
    
}
