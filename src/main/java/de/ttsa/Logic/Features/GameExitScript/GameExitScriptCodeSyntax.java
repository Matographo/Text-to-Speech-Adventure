package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class GameExitScriptCodeSyntax implements CodeSyntaxTestable {

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.EXIT_CODE.toString());
    }
    
}
