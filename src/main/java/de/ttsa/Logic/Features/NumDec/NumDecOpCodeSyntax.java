package de.ttsa.Logic.Features.NumDec;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class NumDecOpCodeSyntax implements OpCodeSyntaxTestable {

private static Pattern pattern = Pattern.compile(Regex.NUMBER_DEC_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
