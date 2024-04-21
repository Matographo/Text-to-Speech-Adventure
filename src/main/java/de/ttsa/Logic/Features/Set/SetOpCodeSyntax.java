package de.ttsa.Logic.Features.Set;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class SetOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.SET.toString());
    }
    
}
