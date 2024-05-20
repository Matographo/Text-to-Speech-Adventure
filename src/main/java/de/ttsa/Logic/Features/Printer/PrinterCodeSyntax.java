package de.ttsa.Logic.Features.Printer;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class PrinterCodeSyntax implements CodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.SAY_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
