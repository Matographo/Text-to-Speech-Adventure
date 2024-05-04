package de.ttsa.Logic.Features.ActionCall;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class ActionCallCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.ACTION_CALL_CODE.toString());
    }
    
}
