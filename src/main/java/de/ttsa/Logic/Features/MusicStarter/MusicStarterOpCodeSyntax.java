package de.ttsa.Logic.Features.MusicStarter;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class MusicStarterOpCodeSyntax  implements OpCodeSyntaxTestable {

    Pattern pattern = Pattern.compile(Regex.MUSIC_STARTER_OPCODE.toString());

    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
