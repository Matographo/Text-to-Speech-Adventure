package de.ttsa.Logic.Features.GameLoaderScript;

import de.ttsa.Enums.Index;
import de.ttsa.Parents.CompilerLineMethods;

public class GameLoaderScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(Index.LOAD).toString();
    }
    
}
