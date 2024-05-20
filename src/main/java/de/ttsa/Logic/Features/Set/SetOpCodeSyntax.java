package de.ttsa.Logic.Features.Set;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class SetOpCodeSyntax implements OpCodeSyntaxTestable {

    private static Pattern pattern = Pattern.compile(Regex.SET_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
