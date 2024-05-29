package de.ttsa.Logic.Features.MusicDec;

import de.ttsa.Enums.Index;
import de.ttsa.Enums.Seperators;
import de.ttsa.Parents.CompilerLineMethods;

public class MusicDecCompiler  extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        String commands = getWithoutCommand(line);
        String[] commandParts = commands.split("=");
        String name = commandParts[0].strip();
        String musicName = commandParts[1].strip() + ".mp3";

        StringBuilder compiled = getStartCode(Index.MUSIC_DEC);
        compiled.append(name);
        compiled.append(Seperators.MUSIC_DEC.getSeperator());
        compiled.append(musicName);

        return compiled.toString();
    }
    
}
