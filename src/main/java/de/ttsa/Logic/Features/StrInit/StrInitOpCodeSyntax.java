package de.ttsa.Logic.Features.StrInit;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class StrInitOpCodeSyntax implements OpCodeSyntaxTestable {
        
    private static Pattern pattern = Pattern.compile(Regex.STR_VARDEC_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
