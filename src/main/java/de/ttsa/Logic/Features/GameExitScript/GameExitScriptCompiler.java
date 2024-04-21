package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Enums.OpCodeIndex;
import de.ttsa.Parents.CompilerLineMethods;

public class GameExitScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder compiled = getStartCode(OpCodeIndex.EXIT);
        compiled.append("0");
        return compiled.toString();
    }
    
}
