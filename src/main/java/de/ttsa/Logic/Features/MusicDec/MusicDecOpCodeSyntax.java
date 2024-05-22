package de.ttsa.Logic.Features.MusicDec;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.OpCodeSyntaxTestable;

public class MusicDecOpCodeSyntax implements OpCodeSyntaxTestable {

    Pattern pattern = Pattern.compile(Regex.MUSIC_DEC_OPCODE.toString());
    
    @Override
    public boolean testOpCode(String arg) {
        return pattern.matcher(arg).matches();
    }
    
}
