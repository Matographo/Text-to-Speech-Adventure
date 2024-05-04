package de.ttsa.Logic.Features.Set;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class SetCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.SET_CODE.toString());
    }
    
}
