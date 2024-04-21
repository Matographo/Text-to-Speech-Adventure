package de.ttsa.Logic.Features.Input;

import de.ttsa.Logic.Compiler.Compiler.CompileC.CompilerLineMethods;
import de.ttsa.Logic.Enums.OpCodeIndex;

public class InputCompiler extends CompilerLineMethods {

    @Override
    public String compile(String line) {
        return getStartCode(OpCodeIndex.INPUT).toString();
    }
    
}
