package de.ttsa.Logic.Features.LoopBreaker;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class LoopBreakerCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.strip().isEmpty();
    }
    
}
