package de.ttsa.Logic.Features.Input;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class InputCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.strip().isEmpty();
    }
    
}
