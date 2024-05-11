package de.ttsa.Logic.Features.If;

import de.ttsa.Interfaces.CodeSyntaxTestable;

public class ElseCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.substring(0, code.lastIndexOf("{")).strip().isEmpty();
    }
    
}
