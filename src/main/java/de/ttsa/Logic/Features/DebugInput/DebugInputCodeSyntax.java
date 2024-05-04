package de.ttsa.Logic.Features.DebugInput;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class DebugInputCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.DEBUG_CODE.toString());
    }
    
}
