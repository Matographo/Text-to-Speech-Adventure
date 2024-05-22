package de.ttsa.Logic.Features.MusicDec;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class MusicDecCodeSyntax  implements CodeSyntaxTestable {

    Pattern pattern = Pattern.compile(Regex.MUSIC_DEC_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
