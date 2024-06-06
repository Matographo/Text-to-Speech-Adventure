package de.ttsa.Logic.Features.MusicStarter;

import de.ttsa.Container.OpCodeVar;
import de.ttsa.Interfaces.CodeVarTestable;

public class MusicStarterCodeVar  implements CodeVarTestable {

    @Override
    public boolean test(String toTest, OpCodeVar opCodeVar) {
        toTest = toTest.strip().replaceAll("\\s{2,}", " ");
        String[] arg = toTest.split(" ");
        if(arg.length == 1) {
            if(arg[0].equals("Stop") || arg[0].equals("Next")) return true;
        }
        for(String s : arg) {
            if(!opCodeVar.isMusicName(s)) return false;
        }
        return true;
    }
    
}