package de.ttsa.Logic.Features.GameLoaderScript;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class GameLoaderScriptCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.strip().isEmpty();
    }
    
}
