package de.ttsa.Logic.Features.GameSavingScript;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class GameSavingScriptCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.strip().isEmpty();
    }
    
}
