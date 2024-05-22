package de.ttsa.Logic.Features.MusicStarter;

import java.util.regex.Pattern;

import de.ttsa.Enums.Regex;
import de.ttsa.Interfaces.CodeSyntaxTestable;

public class MusicStarterCodeSyntax implements CodeSyntaxTestable {

    Pattern pattern = Pattern.compile(Regex.MUSIC_STARTER_CODE.toString());

    @Override
    public boolean testCode(String code) {
        return pattern.matcher(code).matches();
    }
    
}
