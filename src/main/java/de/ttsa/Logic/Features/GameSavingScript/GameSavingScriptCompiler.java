package de.ttsa.Logic.Features.GameSavingScript;

import de.ttsa.Enums.Index;
import de.ttsa.Parents.CompilerLineMethods;

public class GameSavingScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(Index.SAVE).toString();
    }
    
}
