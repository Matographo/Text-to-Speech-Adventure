package de.ttsa.Logic.Features.Action;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class ActionOpCodeSyntax implements OpCodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.ACTION_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
