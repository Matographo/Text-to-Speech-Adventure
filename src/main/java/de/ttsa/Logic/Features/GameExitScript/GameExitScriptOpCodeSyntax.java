package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Enums.OpCodeRegex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class GameExitScriptOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(OpCodeRegex.EXIT.toString());
    }
    
}
