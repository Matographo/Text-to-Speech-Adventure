package de.ttsa.Logic.Features.Printer;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class PrinterOpCodeSyntax implements OpCodeSyntaxTestable {
        
    private static Pattern pattern = Pattern.compile(Regex.SAY_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
