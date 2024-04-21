package de.ttsa.Logic.Features.GameExitScript;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;

public class GameExitScriptCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        StringBuilder compiled = getStartCode(OpCodeIndex.EXIT);
        compiled.append("0");
        return compiled.toString();
    }
    
}
