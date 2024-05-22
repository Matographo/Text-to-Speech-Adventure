package de.ttsa.Logic.Features.MusicDec;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class MusicDecCodeVar implements CodeVarTestable  {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        String[] arg = toTest.split("=");
        toTest = arg[0].strip();
        return opCodeVar.addMusicName(toTest);
    }
    
}
