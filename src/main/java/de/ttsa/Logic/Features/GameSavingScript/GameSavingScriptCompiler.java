package de.ttsa.Logic.Features.GameSavingScript;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;

public class GameSavingScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.SAVE).toString();
    }
    
}
