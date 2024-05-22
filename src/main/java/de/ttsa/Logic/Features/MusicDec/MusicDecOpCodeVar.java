package de.ttsa.Logic.Features.MusicDec;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class MusicDecOpCodeVar  implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split(Seperators.MUSIC_DEC.getSeperator());

        if(opCodeVar.isMusicName(arg[0])) return false;

        opCodeVar.addMusicName(arg[0]);

        return true;
    }
    
}
