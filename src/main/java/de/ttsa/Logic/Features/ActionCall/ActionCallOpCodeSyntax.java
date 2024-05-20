package de.ttsa.Logic.Features.ActionCall;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class ActionCallOpCodeSyntax implements OpCodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ACTION_CALL_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
