package de.ttsa.Logic.Features.Printer;

import de.ttsa.Logic.ClassTools.OpCode;
import de.ttsa.Logic.Interfaces.OpCodeSyntaxTestable;

public class PrinterOpCodeSyntax extends OpCode implements OpCodeSyntaxTestable {
        
    @Override
    public boolean testOpCode(String arg) {
        return arg.matches(REGEX_SAY);
    }
    
}
