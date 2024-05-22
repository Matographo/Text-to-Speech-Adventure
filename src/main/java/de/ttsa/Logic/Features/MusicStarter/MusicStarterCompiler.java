package de.ttsa.Logic.Features.MusicStarter;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class MusicStarterCompiler  extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder commands = new StringBuilder(getWithoutCommand(line));

        StringBuilder compiled = getStartCode(Index.MUSIC_STARTER);

        compiled.append(commands.toString().strip().replaceAll("\\s{2,}", " ").replaceAll(" ", Seperators.MUSIC_STARTER.getSeperator()));
        
        return compiled.toString();
    }
    
}
