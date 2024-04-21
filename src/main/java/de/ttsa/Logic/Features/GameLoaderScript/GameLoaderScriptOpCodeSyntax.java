package de.ttsa.Logic.Features.GameLoaderScript;

import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class GameLoaderScriptOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.strip().isEmpty();
    }
    
}
