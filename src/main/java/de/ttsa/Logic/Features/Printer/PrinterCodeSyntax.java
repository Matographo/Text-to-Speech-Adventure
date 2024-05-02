package de.ttsa.Logic.Features.Printer;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class PrinterCodeSyntax implements CodeSyntaxTestable{

    @Override
    public boolean testCode(String code) {
        return code.matches(Regex.SAY_CODE.toString());
    }
    
}
