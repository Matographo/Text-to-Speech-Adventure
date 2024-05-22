package de.ttsa.Logic.Features.MusicDec;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class MusicDecCompiler  extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);

        StringBuilder compiled = getStartCode(Index.MUSIC_DEC);
        compiled.append(commands.replaceAll(" ", "").replace("=", Seperators.MUSIC_DEC.getSeperator()));

        return compiled.toString();
    }
    
}
