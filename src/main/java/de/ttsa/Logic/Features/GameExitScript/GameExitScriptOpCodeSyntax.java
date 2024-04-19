package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class GameExitScriptOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_EXIT);
    }
    
}
