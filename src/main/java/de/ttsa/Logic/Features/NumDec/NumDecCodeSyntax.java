package de.ttsa.Logic.Features.NumDec;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class NumDecCodeSyntax  implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.NUMBER_DEC_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
