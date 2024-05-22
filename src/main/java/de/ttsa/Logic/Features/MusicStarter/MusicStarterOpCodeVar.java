package de.ttsa.Logic.Features.MusicStarter;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Enums.Seperators;
import de.ttsa.Interfaces.OpCodeVarTestable;

public class MusicStarterOpCodeVar  implements OpCodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        boolean result = true;
        String[] args = toTest.split(Seperators.MUSIC_STARTER.getSeperator());
        for(String arg : args) {
            if(!opCodeVar.isMusicName(arg)) return false;
        }
        return result;
    }
    
}
