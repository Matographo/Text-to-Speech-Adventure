package de.ttsa.Logic.Features.GameLoaderScript;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;

public class GameLoaderScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.LOAD).toString();
    }
    
}
