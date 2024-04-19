package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeTestable;

public class GameExitScriptOpCodeSyntax extends OpCode implements OpCodeTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_EXIT);
    }
    
}
