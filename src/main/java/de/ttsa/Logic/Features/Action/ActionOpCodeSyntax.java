package de.ttsa.Logic.Features.Action;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class ActionOpCodeSyntax implements OpCodeSyntaxTestable {

    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.ACTION.toString());
    }
    
}
