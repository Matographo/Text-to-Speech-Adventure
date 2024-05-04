package de.ttsa.Logic.Features.NumDec;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class NumDecCodeSyntax  implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.NUMBER_DEC_CODE.toString());
    }
    
}
