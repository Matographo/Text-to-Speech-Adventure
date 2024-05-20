package de.ttsa.Logic.Features.GameExitScript;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class GameExitScriptCodeSyntax implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.EXIT_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
