package de.ttsa.Logic.Features.StrDec;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class StrDecCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.STR_DEC_CODE.toString());
    }
    
}
