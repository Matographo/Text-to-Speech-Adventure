package de.ttsa.Logic.Features.StrInit;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class StrInitCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.STR_VARDEC_CODE.toString());
    }
    
}
