package de.ttsa.Logic.Features.Loop;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class LoopCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.LOOP_CODE.toString());
    }
    
}
