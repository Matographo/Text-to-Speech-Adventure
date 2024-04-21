package de.ttsa.Logic.Features.GameSavingScript;

import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class GameSavingScriptOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
