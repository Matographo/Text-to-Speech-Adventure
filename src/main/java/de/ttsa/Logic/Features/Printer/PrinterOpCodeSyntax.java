package de.ttsa.Logic.Features.Printer;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class PrinterOpCodeSyntax implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(Regex.SAY.toString());
    }
    
}
