package de.ttsa.Logic.Features.Action;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class ActionCodeSyntax implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ACTION_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }

}
